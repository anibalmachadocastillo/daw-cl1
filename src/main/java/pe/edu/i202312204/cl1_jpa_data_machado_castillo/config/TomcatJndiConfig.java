package pe.edu.i202312204.cl1_jpa_data_machado_castillo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Configuration
public class TomcatJndiConfig {

    @Value("${DB_WORLD_URL}")
    private String dbWorldUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWorldUser;
    @Value("${DB_WORLD_PASSWORD}")
    private String dbWorldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(dbWorldUrl);
        config.setUsername(dbWorldUser);
        config.setPassword(dbWorldPass);
        config.setDriverClassName(dbWorldDriver);

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);

    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatFactoryCustomizer(HikariDataSource hikariDataSource) {
        return factory -> factory.addConnectorCustomizers(context->{
            try{
                Context initContext = new InitialContext();
                initContext.bind("java:comp/env/jdbc/MyWorld",hikariDataSource);
            }catch (NamingException e){
                e.printStackTrace();
            }
        });
    }
}
