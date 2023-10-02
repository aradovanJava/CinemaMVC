package hr.apisit.cinemamvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class CinemaMvcApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CinemaMvcApplication.class, args);
    }

}
