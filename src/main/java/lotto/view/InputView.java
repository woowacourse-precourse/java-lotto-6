package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public interface InputView {

    public String getPurchasePrice();

    public String getWinningNumbers();

    public String getAskBonusNumber();

    default void print(String printMessage) {
        System.out.println(printMessage);
    }

    default String getInput() {
        return Console.readLine();
    }
}
