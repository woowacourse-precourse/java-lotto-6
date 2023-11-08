package lotto.controller.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.COUNT_STEP;

import java.util.List;
import lotto.model.constant.LottoWinningCase;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBonus;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTicketList;

public class LottoWinningCaseCounter {

	public void countWinningCase(Lotto lotto, LottoBonus lottoBonus,
		LottoTicketList lottoTicketList, List<Integer> winningCaseCountList) {
		LottoWinningCaseChecker lottoWinningCaseChecker = new LottoWinningCaseChecker();
		for (LottoTicket lottoTicket : lottoTicketList.getLottoTicketList()) {
			LottoWinningCase lottoWinningCase = lottoWinningCaseChecker.checkLottoWinningCase(lotto,
				lottoBonus, lottoTicket);
			Integer lottoWinningCaseIndex = lottoWinningCase.ordinal();
			Integer currentCountOfWinningCase = winningCaseCountList.get(lottoWinningCaseIndex);
			winningCaseCountList.set(lottoWinningCaseIndex,
				currentCountOfWinningCase + COUNT_STEP.getValue());
		}
	}
}
