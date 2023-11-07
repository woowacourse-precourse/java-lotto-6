package lotto.View;
import camp.nextstep.edu.missionutils.Console;

public class OutputView{
	public enum Message{
		Lotto_Budget_Message("구입금액을 입력해 주세요."),
		Lotto_Bought_Number_Message("%d개를 구매했습니다.\n"),
		What_is_Lotto_Number_Message("당첨 번호를 입력해 주세요."),
		What_is_Bonus_Number_Message("보너스 번호를 입력해 주세요."),
		Result_Statistics("당첨 통계\n---"),
		RankFive_Message("3개 일치 (5,000원) - %d개\n"),
		RankFour_Message("4개 일치 (50,000원) - %d개\n"),
		RankThree_Message("5개 일치 (1,500,000원) - %d개\n"),
		RankTwo_Message("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
		RankOne_Message("6개 일치 (2,000,000,000원) - %d\n개"),
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
		System.out.println(Message.Result_Statistics.label());
	}
	public static void Print_RankFive_Message(Integer Match) {
		System.out.printf(Message.RankFive_Message.label(),Match);
	}
	public static void Print_RankFour_Message(Integer Match) {
		System.out.printf(Message.RankFour_Message.label(), Match);
	}
	public static void Print_RankThree_Message(Integer Match) {
		System.out.printf(Message.RankThree_Message.label(),Match);
	}
	public static void Print_RankTwo_Message(Integer Match) {
		System.out.printf(Message.RankTwo_Message.label(),Match);
	}
	public static void Print_RankOne_Message(Integer Match) {
		System.out.printf(Message.RankOne_Message.label(),Match);
	}
	public static void Print_Roe_Message(Double Roe) {
		System.out.printf(Message.Roe_Result_Message.label(),Roe);
	}
}