package enums;

public enum Output {

	YOUR_LOTTO("개를 구매했습니다."),
	WIN_STATS("당첨통계"),
	LINE("---"),
	SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
	FIVE_bONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIVE_MATCHES("5개 일치 (1,500,000원) - "),
	FOUR_MATCHES("4개 일치 (50,000원) - "),
	THREE_MATCHES("3개 일치 (5,000원) - "),
	SOME("개"),
	TOTAL_INCOME_RATE_FIRST("총 수익률은 "),
	TOTAL_INCOME_RATE_SECOND("%입니다.");
	
	final private String output; 

	Output(String output) {
		this.output = output;
	}
	
	public String getOutput() {
		return output;
	}
}
