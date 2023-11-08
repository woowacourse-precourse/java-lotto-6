package lotto;

import controller.LottoStoreController;

public class Application {
	public static void main(String[] args) {
		LottoStoreController lottoStoreController = new LottoStoreController();
		lottoStoreController.runLottoGame();
	}
}
