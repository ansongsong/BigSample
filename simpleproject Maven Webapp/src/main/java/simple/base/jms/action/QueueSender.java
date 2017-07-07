package simple.base.jms.action;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueSender {

	public static void main(String[] args) throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.1.8:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("my-queue");
//		消息生产者
		MessageProducer producer = session.createProducer(destination);
		
		for(int i=0;i<1;i++){
			MapMessage message = session.createMapMessage();
			message.setStringProperty("extra"+i, "okok");
			message.setString("message----"+i, "my map message 777=="+i);
//			通过消息生产者发出消息
			producer.send(message);
			
		}
		
		session.commit();session.close();connection.close();
	}
}
