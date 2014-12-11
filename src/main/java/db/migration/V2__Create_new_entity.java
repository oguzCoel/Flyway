package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;


public class V2__Create_new_entity implements SpringJdbcMigration {
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute("create table Person (id int not null auto_increment, first_name VARCHAR(50), last_name VARCHAR(50), primary key(id))");
    }
}