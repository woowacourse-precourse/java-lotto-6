package lotto.controller.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_FOCUS_NUMBER;
import static lotto.model.constant.WinningCaseCountConstantEnum.INITIALIZE_COUNT;
import static lotto.model.constant.WinningCaseCountConstantEnum.WINNING_MIN_COUNT;

import lotto.model.constant.LottoWinningCase;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBonus;
import lotto.model.lotto.LottoTicket;

public class LottoWinningCaseChecker {

	private static final boolean INITIALIZE_BOOLEAN = false;
	public LottoWinningCase checkLottoWinningCase(
		Lotto lotto, LottoBonus lottoBonus, LottoTicket lottoTicket) {
		LottoSameNumberCounter lottoSameNumberCounter = new LottoSameNumberCounter();
		LottoBonusNumberComparator lottoBonusNumberComparator = new LottoBonusNumberComparator();
		int countedValueOfLottoSameNumber = lottoSameNumberCounter.countLottoSameNumber(lotto, lottoTicket);
		Boolean comparedValueOfLottoBonusNumber = lottoBonusNumberComparator.compareLottoBonusNumber(lottoBonus, lottoTicket);
		if (countedValueOfLottoSameNumber < WINNING_MIN_COUNT.getValue()){
			countedValueOfLottoSameNumber = INITIALIZE_COUNT.getValue();
			comparedValueOfLottoBonusNumber = INITIALIZE_BOOLEAN;
		}
		int counterForInterate = LottoWinningCase.values().length-INDEX_FOCUS_NUMBER.getValue();
		return LottoWinningCase.findWinningCaseByValue(countedValueOfLottoSameNumber, comparedValueOfLottoBonusNumber, counterForInterate);
	}

}
