package Spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import Spring.di.entity.Exam;

public class inlineExamConsole implements ExamConsole {
	
	@Autowired(required = false) //기본생성자를 호출하면서 인젝션 됨.
	@Qualifier("exam1")
	private Exam exam;
	
	public inlineExamConsole() {
		System.out.println("constructor");
	}
	
//	@Autowired
//	public inlineExamConsole(
//			@Qualifier("exam1")Exam exam,
//			@Qualifier("exam2")Exam exam2) {
//		//super();
//		System.out.println("overload-constructor");
//		this.exam = exam;
//	}
	

	public inlineExamConsole(Exam exam) {
		//super();
		System.out.println("overload-constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam==null) System.out.printf("total is %d, avg is %f\n",0,0.0);
		else System.out.printf("total is %d, avg is %f\n",exam.total(),exam.avg());

	}
	
//	@Autowired //세터함수가 호출되면서 인젝션 됨. 자동으로 세팅하도록 함(타입으로 매칭함. 동일한 타입이 2개 이상일 경우에는 Qualifier를 사용하여 id로 매칭해야 함. )
//	@Qualifier("exam1")//어떤 id를 매칭할지 설정해줌.
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
		
	}

}
