package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public interface InputView {

    String getPurchasePrice();

    String getWinningNumbers();

    String getBonusNumber();

    default void print(String printMessage) {
        System.out.println(printMessage);
    }

    default String getInput() {
        return Console.readLine();
    }
}
