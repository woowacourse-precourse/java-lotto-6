package lotto;

public enum LottoResult {
	NONEFIT (0, 0, ""),
	THREEFIT (3, 5000, "3개 일치 (5,000원) - "),
	FOURFIT (4, 50000, "4개 일치 (50,000원) - "),
	FIVEFIT (5, 1500000, "5개 일치 (1,500,000원) - "),
	FIVEANDBONUSFIT(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	ALLFIT ( 6, 2000000000, "6개 일치 (2,000,000,000원) - ");
	
	public int howMany = 0;
	public int howMuch = 0;
	public String message = "";
	
	LottoResult(int howMany, int howMuch, String message) {
		this.howMany = howMany;
		this.howMuch = howMuch;
		this.message = message;
	}
}