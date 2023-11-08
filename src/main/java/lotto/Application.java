package lotto;

import lotto.controller.GameController;
import lotto.util.UniqueRandomNumbersGenerator;

public class Application {

	public static void main(String[] args) {
		GameController gameController = new GameController(
			new UniqueRandomNumbersGenerator()
		);
		gameController.play();

	}
}
