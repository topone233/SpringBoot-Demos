package cn.sju.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	// ע��ķ������������ա�/app/hello��·������������Ϣ���������Ϣת����@SendTo�����·���ϡ�
	@MessageMapping("/hello")
	
	// �����������Ϣ������Ϣ����broker������broker���й㲥
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception {
		return message;
	}
}
