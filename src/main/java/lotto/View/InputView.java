package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.Constant;
import lotto.Domain.Money;

public class InputView {

    private static InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public Money inputMoney() {
        System.out.println(Constant.INPUT_PRICE_MESSAGE);
        return new Money(Console.readLine());
    }
}
