package lotto.controller;

import java.util.*;
import lotto.model.InputData;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.view.OutputView;

public class LottoController {
	//플레이어 로또 구매
	private static void playerBuyLotto() {
		OutputView.printBuyInstruction();
		int playerFinance = InputData.playerFinance();
		List<Lotto> playerLottos = LottoService.createObjectPerThousandUnits(playerFinance);
		OutputView.printNumberOfLottosPurchased(playerLottos);
		OutputView.printPlayerLottos(playerLottos);
	}
	
	private static void matchLottosToPrizes() {
		OutputView.printWinningNumberInstruction();
		List<Integer> winningNumbers = InputData.winningNumber();
		OutputView.printBonusNumberInstruction();
		int bonusNumber = InputData.bonusNumber(winningNumbers);
		winningNumbers.add(bonusNumber);
	}
	
	
	//실행
	public static void run() {
		playerBuyLotto();
		matchLottosToPrizes();
	}
	
}
