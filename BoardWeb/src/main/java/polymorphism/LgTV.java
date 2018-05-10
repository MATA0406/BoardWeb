package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LgTV -- 전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV -- 전원 끈다.");
	}
	
	public void volumeUp() {
		/*System.out.println("LgTV -- 소리를 올린다.");*/
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		/*System.out.println("LgTV -- 소리를 줄인다.");*/
		speaker.volumeDown();
	}
}
