package yang.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * User:小小星仔
 * Date:2025-05-08
 * Time:15:35
 */
@SpringBootApplication
@MapperScan("yang.example.mapper")
public class MainPayment1 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment1.class, args);
    }
}
