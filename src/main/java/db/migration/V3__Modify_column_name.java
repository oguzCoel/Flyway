package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;


public class V3__Modify_column_name implements SpringJdbcMigration {
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute("ALTER TABLE app_user ADD COLUMN surname varchar (50)");
        jdbcTemplate.execute("UPDATE app_user SET surname=last_name");
        jdbcTemplate.execute("ALTER TABLE app_user DROP COLUMN last_name");
    }
}