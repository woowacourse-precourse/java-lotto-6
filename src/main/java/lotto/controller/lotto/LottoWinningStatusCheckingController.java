package lotto.controller.lotto;

import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBonus;
import lotto.model.lotto.LottoTicketList;
import lotto.model.lotto.LottoWinningStatus;

public class LottoWinningStatusCheckingController {
	private static final List<Integer> INITIAL_LIST = Arrays.asList(0,0,0,0,0,0);
	public void checkLottoWinningStatus(Lotto lotto, LottoBonus lottoBonus, LottoTicketList lottoTicketList, LottoWinningStatus lottoWinningStatus) {
		List<Integer> winningCaseCountList = INITIAL_LIST;
		new LottoWinningCaseCounter().countWinningCase(lotto, lottoBonus, lottoTicketList, winningCaseCountList);
		lottoWinningStatus.setLottoWinningCaseCountList(winningCaseCountList);
		LottoWinningProfitCalculator lottoWinningProfitCalculator = new LottoWinningProfitCalculator();
		Double lottoWinningProfit = lottoWinningProfitCalculator.calculateLottoWinningProfit(lottoTicketList, winningCaseCountList);
		lottoWinningStatus.setLottoWinningProfit(lottoWinningProfit);
//		System.out.println(lottoWinningStatus.getLottoWinningCaseCountList());
//		System.out.println(lottoWinningStatus.getLottoWinningProfit());
	}
}
