package simple.base.jms.action;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
/**
 * 使用spring框架之后的JMS发送
 * @author company
 *
 */
@Service
public class SpringQueueSend {

//	@Autowired
//	private JmsTemplate jt = null;
//	public static void main(String[] args) throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/springmvc.xml","spring/applicationContext-base-dao.xml","spring/applicationContext-base-service.xml","spring/applicationContext-business-service.xml");
//		SpringQueueSend ct = (SpringQueueSend) ctx.getBean("springQueueSend");
//		
//		ct.jt.send(new MessageCreator() {
//			
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				// TODO Auto-generated method stub
//				TextMessage msg = session.createTextMessage("11111");
//				return null;
//			}
//		});
//	}
	
	
	public static void main(String[] args) {
	       ApplicationContext context;  
	       context = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/springmvc.xml","spring/applicationContext-base-dao.xml","spring/applicationContext-base-service.xml","spring/applicationContext-business-service.xml");
		   JmsTemplate template = (JmsTemplate) context.getBean("jmsTemplate");
//	       Destination destination = (Destination) context.getBean("destination"); 
//	       template.send(destination,new MessageCreator() {
	       template.send(new MessageCreator() {
	           public Message createMessage(Session session) throws JMSException {
	               MapMessage message=session.createMapMessage();
	               message.setString("userId","124563");
	               message.setString("userName", "张三3");
	               message.setInt("age", 223);
	               return message;  
	           }
	       });  
	       System.out.println("成功发送了一条JMS消息");  
	}
}
