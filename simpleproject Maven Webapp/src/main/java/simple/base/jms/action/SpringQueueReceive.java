package simple.base.jms.action;

import java.util.HashMap;

import javax.jms.QueueReceiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service
public class SpringQueueReceive {

	@Autowired
	private JmsTemplate jt = null;
	public static void main(String[] args) throws Exception{
		ApplicationContext context;  
	    context = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/springmvc.xml","spring/applicationContext-base-dao.xml","spring/applicationContext-base-service.xml","spring/applicationContext-business-service.xml");
		SpringQueueReceive ct = (SpringQueueReceive) context.getBean("springQueueReceive");
		HashMap msg = (HashMap) ct.jt.receiveAndConvert();
		for(Object msgs:msg.keySet()){
			msg.get(msgs);
			System.out.println("msg=="+msg.get(msgs));
			
		}
		
	}
}
