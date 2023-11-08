package lotto.View;
import camp.nextstep.edu.missionutils.Console;

public class OutputView{
	public enum Message{
		Lotto_Budget_Message("구입금액을 입력해 주세요."),
		Lotto_Bought_Number_Message("%d개를 구매했습니다."),
		What_is_Lotto_Number_Message("당첨 번호를 입력해 주세요."),
		What_is_Bonus_Number_Message("보너스 번호를 입력해 주세요."),
		Result_Statistics("당첨 통계\n---"),
		RankFive_Message("3개 일치 (5,000원) - %d개"),
		RankFour_Message("4개 일치 (50,000원) - %d개"),
		RankThree_Message("5개 일치 (1,500,000원) - %d개"),
		RankTwo_Message("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
		RankOne_Message("6개 일치 (2,000,000,000원) - %d개"),
		Roe_Result_Message("총 수익률은 %s%%입니다."),;

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
		String message= String.format(Message.Lotto_Bought_Number_Message.label(), Purchase_Number);
		System.out.println(message);
	}
	public static void Print_Lotto_Input_Message() {
		System.out.println(Message.What_is_Lotto_Number_Message.label());
	}
	public static void Print_Bonus_Input_Message() {
		System.out.println(Message.What_is_Bonus_Number_Message.label());
	}
	public static void Print_Stats_Message() {
		System.out.println(Message.Result_Statistics.label());
	}
	public static void Print_RankFive_Message(Integer Match) {
		String message= String.format(Message.RankFive_Message.label(),Match);
		System.out.println(message);
	}
	public static void Print_RankFour_Message(Integer Match) {
		String message= String.format(Message.RankFour_Message.label(), Match);
		System.out.println(message);
	}
	public static void Print_RankThree_Message(Integer Match) {
		String message= String.format(Message.RankThree_Message.label(),Match);
		System.out.println(message);
	}
	public static void Print_RankTwo_Message(Integer Match) {
		String message= String.format(Message.RankTwo_Message.label(),Match);
		System.out.println(message);
	}
	public static void Print_RankOne_Message(Integer Match) {
		String message= String.format(Message.RankOne_Message.label(),Match);
		System.out.println(message);
	}
	public static void Print_Roe_Message(String Roe) {
		String message= String.format(Message.Roe_Result_Message.label(),Roe);
		System.out.println(message);
	}
}