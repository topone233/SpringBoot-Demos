package cn.sju.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
 * WebSocket������
 * spring�ṩ�˻���websocket��stomp֧��
 * stomp��һ���򵥵Ŀɻ�������Э�飬ͨ��������ͨ���м�������ڿͻ���֮������첽��Ϣ���ݡ�
 */

@Configuration

// ��ע�����ڿ���WebSocket��Ϣ����
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// ������Ϣ�����ǰ׺���������Ϣ��ǰ׺�ǡ�/topic���ͻὫ��Ϣת������Ϣ����broker����������Ϣ������Ϣ�㲥����ǰ���ӵĿͻ��ˡ�
		config.enableSimpleBroker("/topic");
		
		// ����һ������ǰ׺��ͨ��ǰ׺���˳���Ҫ��ע�ⷽ���������Ϣ�������Ľ���ֱ�ӽ���broker����
		config.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		// ����һ��ǰ׺Ϊ��/chat����endPoint��������sockjs֧�֡�
		// sockjs���Խ���������websocket�ļ��������⣬�ͻ��˽�ͨ���������õ�URL������websocket����
		registry.addEndpoint("/chat").withSockJS();
	}
}
 