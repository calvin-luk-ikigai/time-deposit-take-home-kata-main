package org.ikigaidigital.interest;

public enum PlanType {
    BASIC("basic"),
    STUDENT("student"),
    PREMIUM("premium");

    private final String value;

    PlanType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PlanType fromString(String text) {
        for (PlanType b : PlanType.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
