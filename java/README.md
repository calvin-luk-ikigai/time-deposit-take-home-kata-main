# Deposit Service
## Starting Deposit Service

### Database Setup (Local)
1. Install PostgreSQL database.
2. Update `application.properties` and `application-test.properties` with the credentials configured.
3. Start PostgreSQL database.

### Initialising Database Tables
1. Connect to PostgreSQL database.
2. Run the create database script in `java/src/main/resources/db_scripts/1_create_db.sql`.
3. Start the application with `DepositService`.
4. The application should then populate the database tables accordingly.
