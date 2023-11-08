package lotto;

import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleOutput.buyInfoMessage();
        ConsoleInput.buy();
        ConsoleOutput.showLottos();
        ConsoleInput.winningNumbers();
        ConsoleInput.bonusNumber();
        ConsoleOutput.resultMessage();
    }
}
