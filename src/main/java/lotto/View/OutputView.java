package lotto.View;
import camp.nextstep.edu.missionutils.Console;

public class OutputView{
	public enum Message{
		Lotto_Budget_Message("구입금액을 입력해 주세요."),
		Lotto_Bought_Number_Message("%d개를 구매했습니다.\n"),
		What_is_Lotto_Number_Message("당첨 번호를 입력해 주세요."),
		What_is_Bonus_Number_Message("보너스 번호를 입력해 주세요."),
		Resul_Statistics("당첨 통계\n---"),
		Three_Correct_Message("3개 일치 (5,000원) - %d개\n"),
		Four_Correct_Message("4개 일치 (50,000원) - %d개\n"),
		Five_Correct_Message("5개 일치 (1,500,000원) - %d개\n"),
		Bonus_Correct_Message("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
		Six_Correct_Message("6개 일치 (2,000,000,000원) - %d\n개"),
		Roe_Result_Message("총 수익률은 %g%입니다.\n"),;

		private final String label;

		    Message(String label) {
		        this.label = label;
		    }
		    public String label() {
		        return label;
		    }
		}

	
	public static void Print_Budget_Message() {
		System.out.println(Message.Lotto_Budget_Message.label());
	}
	public static void Print_Purchase_Message(Integer Purchase_Number) {
		System.out.printf(Message.Lotto_Bought_Number_Message.label(), Purchase_Number);
	}
	public static void Print_Lotto_Input_Message() {
		System.out.println(Message.What_is_Lotto_Number_Message.label());
	}
	public static void Print_Bonus_Input_Message() {
		System.out.println(Message.What_is_Bonus_Number_Message.label());
	}
	public static void Print_Stats_Message() {
		System.out.println(Message.Resul_Statistics.label());
	}
	public static void Print_Three_Message(Integer Match) {
		System.out.printf(Message.Three_Correct_Message.label(),Match);
	}
	public static void Print_Four_Message(Integer Match) {
		System.out.printf(Message.Four_Correct_Message.label(), Match);
	}
	public static void Print_Five_Message(Integer Match) {
		System.out.printf(Message.Five_Correct_Message.label(),Match);
	}
	public static void Print_Bonus_Message(Integer Match) {
		System.out.printf(Message.Bonus_Correct_Message.label(),Match);
	}
	public static void Print_Six_Message(Integer Match) {
		System.out.printf(Message.Six_Correct_Message.label(),Match);
	}
	public static void Print_Roe_Message(Double Roe) {
		System.out.printf(Message.Roe_Result_Message.label(),Roe);
	}
}