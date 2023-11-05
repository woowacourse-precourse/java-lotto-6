package lotto.controller;

import java.util.List;

import lotto.domain.Calculater;
import lotto.domain.Rank;
import lotto.domain.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void start() {
		int buyAmount = InputView.inputPurchaseAmout();
		int lottoCount = Calculater.buyCount(buyAmount);
		List<List<Integer>> LottoTickets = OutputView.buyLotto(lottoCount);
		String winningNumber = InputView.inputWinningNumber();
		String bonusNumber = InputView.inputBonusNumber();
		List<Rank> lottoRanks = Ranking.correct(winningNumber, bonusNumber, LottoTickets);
		int totalPrice = Calculater.profitability(lottoRanks);
		double profit = Calculater.revenue(totalPrice, buyAmount);
		OutputView.totalRateOfReturn(lottoRanks, profit);
	}

}
