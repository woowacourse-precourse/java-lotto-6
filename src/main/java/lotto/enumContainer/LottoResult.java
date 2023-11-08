package lotto.enumContainer;

import lotto.dataObjects.Money;

public enum LottoResult {

	THREE("3개 일치 (5,000원) - ", 5000, 3),
	FOUR("4개 일치 (50,000원) - ", 50000, 4),
	FIVE("5개 일치 (1,500,000원) - ", 1500000, 5),
	FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, -1),
	SIX("6개 일치 (2,000,000,000원) - ", 2000000000, 6);

	private String resultLabel;
	private int benefit;
	private int matchCount;
	public int number;

	LottoResult(String resultLabel, int benefit, int matchType) {
		this.resultLabel = resultLabel;
		this.benefit = benefit;
		this.number = matchType;
	}

	public void reflectResult(Money money) {
		this.matchCount++;
		money.plusBenefit(benefit);
	}

	public String getResultString() {
		return resultLabel + matchCount + "개";
	}

	public void init() {
		this.matchCount = 0;
	}


}
