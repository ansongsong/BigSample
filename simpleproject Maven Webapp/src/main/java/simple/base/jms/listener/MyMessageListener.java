package simple.base.jms.listener;

import java.util.Enumeration;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MyMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
        MapMessage msgs =  (MapMessage) message;
        Enumeration mapNames;
        
		try {
			mapNames = msgs.getMapNames();
			while(mapNames.hasMoreElements()){
				System.out.println("receive msg=="+msgs.getString((String) mapNames.nextElement()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
