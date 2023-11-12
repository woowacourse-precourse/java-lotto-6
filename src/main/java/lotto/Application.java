package lotto;

import lotto.controller.GameController;
import lotto.service.Discriminator;
import lotto.service.Inputter;
import lotto.service.LottoNumberGenerator;
import lotto.service.Printer;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                Inputter.getInputter(),
                Printer.getPrinter(),
                new Discriminator(),
                LottoNumberGenerator.getLottoNumberGenerator()
        );

        gameController.startGame();;
    }
}
