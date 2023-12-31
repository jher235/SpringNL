package Spring.di.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service // 컴포넌트 안에 포함 된 조금 더 세분화 된 역할 서비스, 컨트롤러, 리포시토리 3가지가 있음.
public class NewlecExam implements Exam {
	
	@Value("20")
	private int kor;
	@Value("30")
	private int eng;
	@Value("40")
	private int math;
	@Value("50")
	private int com;
	
	
	
	public NewlecExam() {
		super();
	}



	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}



	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getCom() {
		return com;
	}


	public void setCom(int com) {
		this.com = com;
	}


	@Override
	public int total() {
		
		return kor+eng+math+com;
	}

	
	@Override
	public float avg(){
		
		return total()/4.0f;
	}


	@Override
	public String toString() {
		return "NewlecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}
	
	
}
