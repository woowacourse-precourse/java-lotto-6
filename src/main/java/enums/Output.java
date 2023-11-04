package enums;

public enum Output {

	YOUR_LOTTO("개를 구입했습니다."),
	STATS("당첨통계"),
	SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
	FIVE_bONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIVE_MATCHES("5개 일치 (1,500,000원) - "),
	FOUR_MATCHES("4개 일치 (50,000원) - "),
	THREE_MATCHES("3개 일치 (5,000원) - ");
	
	final private String output; 

	Output(String output) {
		this.output = output;
	}
	
	public String getOutput() {
		return output;
	}
}
