package lotto.view;

import lotto.io.InputStream;
import lotto.util.Validator;

public class InputView {
    InputStream inputStream;

    public InputView(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int inputMoney() throws IllegalArgumentException {
        int money = inputStream.inputInt();
        Validator.checkPositive(money);
        Validator.checkThousandDivision(money);
        return money;
    }
}