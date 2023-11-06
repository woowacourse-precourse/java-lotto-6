package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public interface InputView {

    String askPurchasePrice();

    String askWinningNumbers();

    String askBonusNumber();

    default void print(String printMessage) {
        System.out.println(printMessage);
    }

    default String getInput() {
        return Console.readLine();
    }
}
