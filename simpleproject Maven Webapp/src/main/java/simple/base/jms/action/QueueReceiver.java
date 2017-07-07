package simple.base.jms.action;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueReceiver {

	public static void main(String[] args) throws Exception{
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://192.168.1.8:61616");
		Connection connection = cf.createConnection();
		connection.start();
		Enumeration names = connection.getMetaData().getJMSXPropertyNames();
		while(names.hasMoreElements()){
			String name = (String) names.nextElement();
			System.out.println("jmsx name=="+name);
		}
		final Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("my-queue");
		MessageConsumer consumer = session.createConsumer(destination);
//		consumer.setMessageListener(new MessageListener() {
//			
//			@Override
//			public void onMessage(Message message) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		int i=0;
		while(i<3){
			MapMessage message = (MapMessage) consumer.receive();
			if(i==2){
				message.acknowledge();
			}
			System.out.println("收到消息："+message.getString("message---"+i));
			i++;
		}
		
	}
}
