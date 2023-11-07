package lotto.View;
import camp.nextstep.edu.missionutils.Console;

public class OutputView{
	
	private static final String Lotto_Budget_Message = "구입금액을 입력해 주세요.";
	private static final String Lotto_Bought_Number_Message = "%d개를 구매했습니다./n";
	private static final String What_is_Lotto_Number_Message = "당첨 번호를 입력해 주세요.";
	private static final String What_is_Bonus_Number_Message = "보너스 번호를 입력해 주세요.";
	private static final String Resul_Statistics = "당첨 통계";
	private static final String Three_Correct_Message ="3개 일치 (5,000원) - %d개/n";
	private static final String Four_Correct_Message ="4개 일치 (50,000원) - %d개/n";
	private static final String Five_Correct_Message ="5개 일치 (1,500,000원) - %d개/n";
	private static final String Bonus_Correct_Message = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개/n";
	private static final String Six_Correct_Message ="6개 일치 (2,000,000,000원) - %d/n개";
	private static final String Roe_Result_Message = "총 수익률은 %f%입니다./n";
	
	public static void Print_Budget_Message() {
		System.out.println(Lotto_Budget_Message);
	}
	public static void Print_Purchase_Message(Integer Purchase_Number) {
		System.out.printf(Lotto_Bought_Number_Message, Purchase_Number);
	}
	public static void Print_Lotto_Input_Message() {
		System.out.println(What_is_Lotto_Number_Message);
	}
	public static void Print_Bonus_Input_Message() {
		System.out.println(What_is_Bonus_Number_Message);
	}
	public static void Print_Stats_Message() {
		System.out.println(Resul_Statistics);
	}
	public static void Print_Three_Message(Integer Match) {
		System.out.printf(Three_Correct_Message,Match);
	}
	public static void Print_Four_Message(Integer Match) {
		System.out.printf(Four_Correct_Message, Match);
	}
	public static void Print_Five_Message(Integer Match) {
		System.out.printf(Five_Correct_Message,Match);
	}
	public static void Print_Bonus_Message(Integer Match) {
		System.out.printf(Bonus_Correct_Message,Match);
	}
	public static void Print_Six_Message(Integer Match) {
		System.out.printf(Six_Correct_Message,Match);
	}
	public static void Print_Roe_Message(Float Roe) {
		System.out.printf(Roe_Result_Message,Roe);
	}
}