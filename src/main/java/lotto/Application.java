package lotto;

import lotto.machine.ui.ConsoleUI;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleUI ui = new ConsoleUI();

        ui.requirePurchaseView();
        ui.inputPurchaseAmount();
        ui.requireWinningNumbers();
        List<Integer> winningNumbers = ui.inputWinningNumbers();
        ui.requireBonusNumber();
        ui.inputBonusNumber(winningNumbers);
        ui.outputGameResult(1,2,3,4,5, 55.5);
    }
}
