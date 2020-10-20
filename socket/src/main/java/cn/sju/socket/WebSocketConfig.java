package cn.sju.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
 * WebSocket配置类
 * spring提供了基于websocket的stomp支持
 * stomp是一个简单的可互操作的协议，通常被用于通过中间服务器在客户端之间进行异步消息传递。
 */

@Configuration

// 此注解用于开启WebSocket消息代理
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 设置消息代理的前缀。即如果消息的前缀是“/topic”就会将消息转发给消息代理（broker），再由消息代理将消息广播给当前连接的客户端。
		config.enableSimpleBroker("/topic");
		
		// 配置一个或多个前缀，通过前缀过滤出需要被注解方法处理的消息。其他的将被直接交给broker处理。
		config.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		// 定义一个前缀为“/chat”的endPoint，并开启sockjs支持。
		// sockjs可以解决浏览器对websocket的兼容性问题，客户端将通过这里配置的URL来建立websocket连接
		registry.addEndpoint("/chat").withSockJS();
	}
}
 