package lotto.View;

public enum Enums{
	Lotto_Budget_Message("구입금액을 입력해 주세요."),
	Lotto_Bought_Number_Message("\n%d개를 구매했습니다.\n"),
	What_is_Lotto_Number_Message("\n당첨 번호를 입력해 주세요."),
	What_is_Bonus_Number_Message("\n보너스 번호를 입력해 주세요."),
	Resul_Statistics("\n당첨 통계\n---"),
	Three_Correct_Message("3개 일치 (5,000원) - %d개\n"),
	Four_Correct_Message("4개 일치 (50,000원) - %d개\n"),
	Five_Correct_Message("5개 일치 (1,500,000원) - %d개\n"),
	Bonus_Correct_Message("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
	Six_Correct_Message("6개 일치 (2,000,000,000원) - %d개\n"),
	Roe_Result_Message("총 수익률은 %g%입니다.\n"),;

	private final String label;

	    Enums(String label) {
	        this.label = label;
	    }
	    public String label() {
	        return label;
	    }
	}
	