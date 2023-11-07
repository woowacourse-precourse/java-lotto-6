package lotto;

import lotto.machine.ui.ConsoleUI;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleUI ui = new ConsoleUI();

        ui.requirePurchaseView();
        ui.inputPurchaseAmount();
        ui.requireWinningNumbers();
        ui.inputWinningNumbers();
        ui.requireBonusNumber();
        ui.inputBonusNumber();
        ui.outputGameResult(1,2,3,4,5, 55.5);
    }
}
