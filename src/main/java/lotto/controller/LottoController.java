package lotto.controller;

import java.util.*;
import lotto.model.InputData;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.view.OutputView;

public class LottoController {
	//플레이어 로또 구매
	void playerBuyLotto() {
		OutputView.printBuyInstruction();
		int playerFinance = InputData.playerFinance();
		List<Lotto> playerLottos = LottoService.createObjectPerThousandUnits(playerFinance);
		OutputView.printNumberOfLottosPurchased(playerLottos);
		OutputView.printPlayerLottos(playerLottos);
	}
	
	void matchLottosToPrizes() {
		OutputView.printWinningNumberInstruction();
		
	}
	
	
	//실행
	void run() {
		playerBuyLotto();
	}
	
}
