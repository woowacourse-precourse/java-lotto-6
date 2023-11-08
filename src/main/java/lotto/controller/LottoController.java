package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public LottoController() {
	}

	private static final int TICKET_PRICE = 1000;
	private static final int PERCENTAGE = 100;

	public void run() {
		try {
			start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		int ticketCount = inputPlayerAmount();
		OutputView.printTicketCount(ticketCount);

		List<Lotto> lottoList = makeLottoList(ticketCount);
		WinningResult winningResult = createWinningResult();

		displaylottoResult(lottoList, winningResult, ticketCount);
	}

	public int inputPlayerAmount() {
		PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
		return playerLottoAmount.calculateLottoCount();
	}

	public WinningResult createWinningResult() {
		List<Integer> winningNumber = InputView.inputLottoWinningNum();
		int bonusBall = InputView.inputBonusNumber();

		Lotto lotto = new Lotto(winningNumber);
		return new WinningResult(lotto, bonusBall);
	}

	private static List<Lotto> makeLottoList(int ticketCount) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < ticketCount; i++) {
			lottoList.add(makeLotto());
		}
		return lottoList;
	}

	private static Lotto makeLotto() {
		LottoNumbers lottoNumbers = new LottoNumbers();
		List<Integer> lotto = new ArrayList<>();
		lotto = lottoNumbers.setRandomNumbers();
		System.out.println(lotto);
		return new Lotto(lotto);
	}

	private void displaylottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
		Map<Ranking, Integer> result = initializeResult();
		OutputView.printSuccessResult();
		for (Lotto playerLotto : lottoList) {
			Ranking rank = winningLotto.match(playerLotto);
			result.put(rank, result.get(rank) + 1);
		}
		printResult(result);
		printEarningRate(result, amount);
	}

	private void printResult(Map<Ranking, Integer> result) {
		for (Ranking rank : Ranking.values()) {
			rank.printMessage(result.get(rank));
		}
	}

	private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
		double earningRate = calculateEarningRate(result, lottoAmount);
		OutputView.printRevenueRate(earningRate);
	}

	private double calculateEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
		double earningRate = 0;
		for (Ranking rank : result.keySet()) {
			earningRate += (double) rank.getWinningAmount() / (lottoAmount * TICKET_PRICE) * result.get(rank)
					* PERCENTAGE;
		}
		return earningRate;
	}

	private Map<Ranking, Integer> initializeResult() {
		Map<Ranking, Integer> result = new LinkedHashMap<>();
		for (Ranking rank : Ranking.values()) {
			result.put(rank, 0);
		}
		return result;
	}
}
