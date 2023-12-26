package Spring.di.ui;

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

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
