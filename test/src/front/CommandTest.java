package front;
//==================command pattern========================
//interface 여도 가능
abstract class Command {//틀만 제공
	abstract public void run();//2가지 실행 경우
}
class ACommand extends Command{
	public void run(){
		System.out.println("ACommand실행");
	}
}
class BCommand extends Command{
	public void run(){
		System.out.println("BCommand실행");
	}
}
//=========================================================
//==================factory method pattern
class CommandFactory {
	public Command getCommand(String name){
		Command c = null; //ACommand, BCommand
		if(name.equalsIgnoreCase("a")){
			c = new ACommand();
		}
		else if(name.equalsIgnoreCase("b")){
			c = new BCommand();
		}
		/*else {
			System.out.println("입력오류");
		}*/	
		return c;
	}
}
//입력값 - Command 결정권한 factory : 세부사항 모른다
public class CommandTest {
	public static void main(String[] args) {
		//명령행 매개변수 a A 입력
		/*c.run(); //수행결과 다르다*/	
		CommandFactory factory = new CommandFactory();
		Command c = factory.getCommand(args[0]);
		c.run();
		//새로 객체 생성x : 기존 생성 같은 타입 객체 재사용
		CommandFactory factory2 = new CommandFactory();
		
	}
}
