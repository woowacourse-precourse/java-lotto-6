package lotto.Controller;

import camp.nextstep.edu.missionutils.*;
import java.util.List;
import lotto.*;

import static java.util.stream.IntStream.range;

public class Game{
	
	private Lotto lotto;
	
	public void run() {
		start();
		Result();
	}
	
	public void ticket() {
		
	}
	
	

	
	
	
	public static void start() {
		Integer Lotto_Budget = Lotto_Budget();
		Integer Lotto_Number =null;
		Integer Lotto_Bonus =null;
		
	}
	

//로또구입금액 입
	public static Integer Lotto_Budget(){
		String A = Console.readLine();
		Integer Budget =null;
		try {
			Budget = Integer.parseInt(Console.readLine());
		} catch (Exception e1) {
			throw new IllegalArgumentException("정수를입력하시");
		}
		return Budget;
	}
	
//당첨번호 입력
	public static void Lotto_Number() {
		String B=Console.readLine();
		String C=Console.readLine();
	}
//보너스 번호 입
	//로또발행
	public static void Lotto_Purchase() {
		
	}
//로또 수량 번호 출력
	public static void My_Lottery_Ticket() {
		
	}
//당첨 내역 출력
	public static void Lotto_winner() {
		
	}
	
//수익률 측정
	public static void Lotto_ROE() {
		
	}
}