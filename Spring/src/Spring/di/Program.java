package Spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Spring.di.entity.Exam;
import Spring.di.ui.ExamConsole;
import Spring.di.ui.inlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/*	스프링에게 지시하는 방법으로 코드를 변경 . XML파일을 이용함.
		Exam exam = new NewlecExam();
		
		ExamConsole console = new GridExamConsole(exam);
		console.setExam(exam);
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
//		ExamConsole console = (ExamConsole) context.getBean("console");
		//ExamConsole console = context.getBean(ExamConsole.class);
		
//		Exam exam = context.getBean(Exam.class);
//		System.out.println(exam.toString());
		
		ExamConsole console = context.getBean(inlineExamConsole.class);
		console.print();
		
		//List<Exam> exams = new ArrayList<Exam>();
		//List<Exam> exams = (List<Exam>) context.getBean("exams");
		//exams.add(new NewlecExam(1,1,1,1));
		
//		for(Exam e : exams) {
//			System.out.println(e);
//		}
		
		
	}

}
