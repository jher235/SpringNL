package Spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import Spring.di.entity.Exam;
import Spring.di.entity.NewlecExam;


@ComponentScan({"Spring.di.ui", "Spring.di.entity"})//컴포넌트 스캔을 어려 패키지하고 싶다면 배열 형식으로 해야 함.
@Configuration//설정을 자바 코드로 옮기는 것
public class NewlecDIConfig {
	@Bean//xml의 <bean id="exam" class = "Spring.di.entity.NewlecExam"/>이 코드와 같다.
	public Exam exam(){ //이때 함수명은 id와 같다고 본다.
		return new NewlecExam();
	}
}
