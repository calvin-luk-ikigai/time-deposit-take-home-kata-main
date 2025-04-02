package org.ikigaidigital.sst;

import com.google.gson.Gson;
import org.ikigaidigital.DepositService;
import org.ikigaidigital.application.TimeDepositService;
import org.ikigaidigital.driven.entity.TimeDepositEntity;
import org.ikigaidigital.driven.repository.TimeDepositRepository;
import org.ikigaidigital.driving.dto.UpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DepositService.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TimeDepositSst {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeDepositRepository timeDepositRepository;

    @TestConfiguration
    static class TimeDepositImplTestContextConfiguration {

        @Bean
        public TimeDepositService timeDepositService() {
            return new TimeDepositService();
        }
    }

    @BeforeEach
    void setup() {
        List<TimeDepositEntity> timeDpositEntityList = new ArrayList<>();
        timeDpositEntityList.add(new TimeDepositEntity(1, "basic", BigDecimal.valueOf(1234.0), 60));
        timeDpositEntityList.add(new TimeDepositEntity(2, "student", BigDecimal.valueOf(5678), 60));

        when(timeDepositRepository.findAll()).thenReturn(timeDpositEntityList);
    }

    @Test
    void testGetAllTimeDeposits() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/time-deposits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].balance").value(1234))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].planType").value("basic"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].days").value(60))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].balance").value(5678))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].planType").value("student"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].days").value(60));
    }

    @Test
    void testUpdateAllTimeDeposits() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/time-deposits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].balance").value(1234))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].balance").value(5678));

        BigDecimal balance = BigDecimal.valueOf(2000.0);
        mockMvc.perform(MockMvcRequestBuilders.post("/time-deposits/update-all-balances")
                        .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(new UpdateRequest(balance))))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/time-deposits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].balance").value(balance))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].balance").value(balance));
    }
}
