package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {

    public Integer inputMoney() {
        OutputView.moneyMessage();
        String money= Console.readLine();

        return Integer.parseInt(money);
    }

    public ArrayList<Integer> winningNumber() {
        OutputView.winningMessage();
        String[] winningNumber = Console.readLine().split(",");

        return new ArrayList<>(Arrays.stream(winningNumber)
                                    .map(Integer::parseInt)
                                    .toList());
    }

    public Integer bonusNumber() {
        OutputView.bonusMessage();
        String bonusNumber = Console.readLine();

        return Integer.parseInt(bonusNumber);
    }
}
