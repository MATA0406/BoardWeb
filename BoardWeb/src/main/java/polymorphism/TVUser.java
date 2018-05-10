package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class TVUser {
	public static void main(String[] args) {
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); // 이것만으로 객체가 생성되는 데는 아무 문제가 없다.
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(LookUp)한다.
		TV tv1 = (TV)factory.getBean("tv"); // applicationContext에서 싱글톤 적용으로 객체는 하나만 생성된다.
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
		
		factory.close(); // 3. Spring 컨테이너를 종료(여기선 객체가 삭제하며 처리할 로직을 처리.)
	}
}
