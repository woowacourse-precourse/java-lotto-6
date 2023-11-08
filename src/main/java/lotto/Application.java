package lotto;

import lotto.controller.GameController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		LottoService lottoService = new LottoService();

		GameController gameController = new GameController(
				inputView,
				outputView,
				lottoService);
		gameController.runGame();
	}
}
