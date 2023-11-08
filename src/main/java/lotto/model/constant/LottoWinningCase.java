package lotto.model.constant;

import static lotto.model.constant.IntegerSymbolicConstantEnum.END_OF_COUNT;
import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_PIVOT_STEP;

public enum LottoWinningCase {
	NOTHING(0,false,0, ""),
	FIFTH(3,false,5000, "3개 일치 (5,000원) - "),
	FOURTH(4,false,50000, "4개 일치 (50,000원) - "),
	THIRD(5,false,1500000, "5개 일치 (1,500,000원) - "),
	SECOND(5,true,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST(6,false,2000000000, "6개 일치 (2,000,000,000원) - ");

	private final int sameNumberCount;
	private final boolean bonusBallExsistence;
	private final int winningMoney;
	private final String describingString;



	LottoWinningCase(int sameNumberCount, boolean bonusBallExsistence, int winningMoney, String describingString) {
		this.sameNumberCount = sameNumberCount;
		this.bonusBallExsistence = bonusBallExsistence;
		this.winningMoney = winningMoney;
		this.describingString = describingString;
	}

	public static LottoWinningCase findWinningCaseByValue(int countedValueOfLottoSameNumber, Boolean comparedValueOfLottoBonusNumber, int counterForInterate) {
		int currentLottoWinningCaseSameNumberCount = LottoWinningCase.values()[counterForInterate].getSameNumberCount();
		boolean currentLottoWinningCaseBonusBallExsistence = LottoWinningCase.values()[counterForInterate].isBonusBallExsistence();
		if (currentLottoWinningCaseSameNumberCount == countedValueOfLottoSameNumber && currentLottoWinningCaseBonusBallExsistence == comparedValueOfLottoBonusNumber){
			return LottoWinningCase.values()[counterForInterate];
		}
		if (counterForInterate == END_OF_COUNT.getValue()){
			return LottoWinningCase.values()[counterForInterate];
		}
		counterForInterate -= INDEX_PIVOT_STEP.getValue();
		return findWinningCaseByValue(countedValueOfLottoSameNumber, comparedValueOfLottoBonusNumber, counterForInterate);
	}


	public int getWinningMoney() {
		return winningMoney;
	}

	public boolean isBonusBallExsistence() {
		return bonusBallExsistence;
	}

	public int getSameNumberCount() {
		return sameNumberCount;
	}
	public String getDescribingString() {
		return describingString;
	}
}
