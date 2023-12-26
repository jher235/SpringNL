package Spring.di;

import Spring.di.entity.Exam;
import Spring.di.entity.NewlecExam;
import Spring.di.ui.ExamConsole;
import Spring.di.ui.GridExamConsole;
import Spring.di.ui.inlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		ExamConsole console = new inlineExamConsole();// DI -> 인라인 이그젬 컨솔이 exam이라는 객체를 조립함
		ExamConsole console2 = new GridExamConsole(exam);
		console.setExam(exam);
		console2.print();
	}

}
