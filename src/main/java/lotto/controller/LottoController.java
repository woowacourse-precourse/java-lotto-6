package lotto.controller;

import static lotto.domain.Calculater.buyCount;
import static lotto.domain.Calculater.profitability;
import static lotto.domain.Calculater.revenue;
import static lotto.domain.Ranking.correct;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseAmout;
import static lotto.view.InputView.inputWinningNumber;
import static lotto.view.OutputView.buyLotto;
import static lotto.view.OutputView.totalRateOfReturn;

import java.util.List;

import lotto.domain.Rank;

public class LottoController {

	public void start() {
		int buyAmount = inputPurchaseAmout();
		int lottoCount = buyCount(buyAmount);
		List<List<Integer>> LottoTickets = buyLotto(lottoCount);
		List<Integer> winningNumber = inputWinningNumber();
		int bonusNumber = inputBonusNumber();
		List<Rank> lottoRanks = correct(winningNumber, bonusNumber, LottoTickets);
		int totalPrice = profitability(lottoRanks);
		double profit = revenue(totalPrice, buyAmount);
		totalRateOfReturn(lottoRanks, profit);
	}

}
