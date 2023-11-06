package lotto.controller;

import java.util.*;
import lotto.model.InputData;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.view.OutputView;

public class LottoController {
	//플레이어 로또 구매
	private static List<Lotto> playerBuyLotto() {
		OutputView.printBuyInstruction();
		int playerFinance = Integer.parseInt(InputData.playerFinance());
		List<Lotto> playerLottos = new ArrayList<Lotto>(LottoService.createObjectPerThousandUnits(playerFinance));
		OutputView.printNumberOfLottosPurchased(playerLottos);
		OutputView.printPlayerLottos(playerLottos);
		return playerLottos;
	}
	
	private static void matchLottosToPrizes(List<Lotto> playerLotto) {
		OutputView.printWinningNumberInstruction();
		List<Integer> winningNumber = InputData.winningNumber();
		OutputView.printBonusNumberInstruction();
		int bonusNumber = InputData.bonusNumber(winningNumber);
		Map<String,Integer> rankCount = LottoService.getTotalWinningRankCount(playerLotto, winningNumber, bonusNumber);
		OutputView.printWinningStatistics(rankCount);
		long totalWinningAmount = LottoService.getTotalWinningAmount(playerLotto, winningNumber, bonusNumber);
		double returnOnInvestment = LottoService.calculateReturnOnInvestment(totalWinningAmount, playerLotto);
		OutputView.printReturnOnInvestment(returnOnInvestment);
	}
	
	
	//실행
	public static void run() {
		List<Lotto> playerLotto =  playerBuyLotto();
		matchLottosToPrizes(playerLotto);
	}
	
}
