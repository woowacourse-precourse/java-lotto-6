package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.constants.PrintMessage.PRINT_GAME_START;

public class Application {
    public static void main(String[] args) {
        OutputView.printMessage(PRINT_GAME_START);
        int purchasePrice = InputView.readPurchasePrice();
        Lotto.create();
    }
}
