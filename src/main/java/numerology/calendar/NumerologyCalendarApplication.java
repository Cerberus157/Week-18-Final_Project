package numerology.calendar;

import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NumerologyCalendarApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NumerologyCalendarApplication.class, args);

        // Grab the application bean and trigger JDBC URL logging
        NumerologyCalendarApplication app = context.getBean(NumerologyCalendarApplication.class);
        app.logJdbcUrl();
    }

    public void logJdbcUrl() {
        try {
            String url = dataSource.getConnection().getMetaData().getURL();
            System.out.println("🔗 Active JDBC URL: " + url);
        } catch (SQLException e) {
            System.err.println("❌ Failed to retrieve JDBC URL:");
            e.printStackTrace();
        }
    }
}