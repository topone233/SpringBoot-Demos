package cn.sju.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WebSocket 自定义用户名  Web多人聊天
 * 聊天内容存储在客户端浏览器
 * @author MI
 *
 */
@SpringBootApplication
public class SocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketApplication.class, args);
	}

}
