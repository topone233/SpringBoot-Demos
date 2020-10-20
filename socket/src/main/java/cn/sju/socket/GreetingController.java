package cn.sju.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	// 注解的方法将用来接收“/app/hello”路径发送来的消息，处理后将消息转发到@SendTo定义的路径上。
	@MessageMapping("/hello")
	
	// 将处理过的消息交给消息代理broker，再由broker进行广播
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception {
		return message;
	}
}
