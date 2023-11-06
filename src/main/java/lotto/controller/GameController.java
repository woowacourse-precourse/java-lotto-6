package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.domain.LottosMaker;
import lotto.domain.SummaryMaker;
import lotto.output.ResultPrinter;

public class GameController {

	int purchaseTime;
	int bonusNumber;
	List<Lotto> lottos;
	List<Integer> winningNumber;

	MakerController makerController = new MakerController();
	SummaryMaker summaryMaker = new SummaryMaker();

	public void playGame() {
		operateLottos();
		operateSummary();
	}

	private void operateLottos() {

		purchaseTime = makerController.makeCorrectPurchaseTime();

		lottos = new ArrayList<>(LottosMaker.make(purchaseTime));
		ResultPrinter.printLottos(lottos, purchaseTime);

		winningNumber = makerController.makeCorrectWinningNumber();
		bonusNumber = makerController.makeCorrectBonusNumber();
	}

	private void operateSummary() {

		Map<String, Integer> summary = summaryMaker.summarizeHit(lottos, winningNumber, bonusNumber);
		double yield = summaryMaker.calculateYield(purchaseTime);

		ResultPrinter.printSummary(summary);
		ResultPrinter.printYield(yield);
	}

}
