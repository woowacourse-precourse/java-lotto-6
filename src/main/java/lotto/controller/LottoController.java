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
		int playerFinance = InputData.playerFinance();
		List<Lotto> playerLottos = LottoService.createObjectPerThousandUnits(playerFinance);
		OutputView.printNumberOfLottosPurchased(playerLottos);
		OutputView.printPlayerLottos(playerLottos);
		return playerLottos;
	}
	
	private static void matchLottosToPrizes(List<Lotto> playerLotto) {
		OutputView.printWinningNumberInstruction();
		List<Integer> winningNumbers = InputData.winningNumber();
		OutputView.printBonusNumberInstruction();
		int bonusNumber = InputData.bonusNumber(winningNumbers);
		OutputView.printWinningStatistics(LottoService.getTotalWinningRankCount(playerLotto, winningNumbers, bonusNumber));
		long totalWinningAmount = LottoService.getTotalWinningAmount(playerLotto, winningNumbers, bonusNumber);
		double roi = LottoService.calculateReturnOnInvestment(totalWinningAmount, playerLotto);
		OutputView.printReturnOnInvestment(roi);
	}
	
	
	//실행
	public static void run() {
		List<Lotto> playerLotto =  playerBuyLotto();
		matchLottosToPrizes(playerLotto);
	}
	
}
