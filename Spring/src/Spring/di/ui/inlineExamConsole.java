package Spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import Spring.di.entity.Exam;

public class inlineExamConsole implements ExamConsole {

	private Exam exam;
	
	public inlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public inlineExamConsole(Exam exam) {
		//super();
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n",exam.total(),exam.avg());

	}
	
	@Autowired //자동으로 세팅하도록 함(타입으로 매칭함. 동일한 타입이 2개 이상일 경우에는 Qualifier를 사용하여 id로 매칭해야 함. )
	@Qualifier("exam1")//어떤 id를 매칭할지 설정해줌.
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
