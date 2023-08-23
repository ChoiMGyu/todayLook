package Yeungnam.YU;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "Yeungnam.YU.mapper") 
//해당 패키지 이하에 위치해 있는 인터페이스들은 모두 mapper로 사용 가능
public class YuApplication { 

	public static void main(String[] args) {
		SpringApplication.run(YuApplication.class, args);
	}

} 
