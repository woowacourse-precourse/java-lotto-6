package lotto.controller;

import java.util.*;
import lotto.model.InputData;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.view.OutputView;

public class LottoController {
	void playerBuyLotto() {
		OutputView.informationBuyMessage();
		int playerFinance = InputData.playerFinance();
		List<Lotto> playerLottos = LottoService.createObjectPerThousandUnits(playerFinance);
	}
	
	
	//실행
	void run() {
		
	}
	
}
