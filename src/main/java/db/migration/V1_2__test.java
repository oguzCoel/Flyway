package db.migration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;

/**
 * Example of a Spring Jdbc migration.
 */
public class V1_2__test implements SpringJdbcMigration {
	@Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute("CREATE TABLE test ( id int)");
        
        
    }
}