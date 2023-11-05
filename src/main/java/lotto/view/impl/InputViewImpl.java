package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.GameMessages;
import lotto.view.InputView;

public class InputViewImpl implements InputView {

    @Override
    public String inputMoney() {
        System.out.println(GameMessages.INPUT_MONEY.getMessage());
        return input();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println(GameMessages.INPUT_LOTTO.getMessage());
        return input();
    }

    @Override
    public String inputBonusNumber() {
        return null;
    }

    String input() {
        return Console.readLine();
    }
}
