package Spring.di.ui;

import Spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {
	
	Exam exam;
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.printf("total is %d\navg is %f\n",exam.total(), exam.avg());

	}

}
