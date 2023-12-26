package Spring.di.ui;

import Spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {
	
	Exam exam;
	
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.printf("total is %d\navg is %f\n",exam.total(), exam.avg());

	}

	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam = exam;
	}

}
