package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.Constant;
import lotto.Domain.Bonus;
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

    public Bonus inputBonus() {
        System.out.println(Constant.INPUT_BONUS_MESSAGE);
        return new Bonus(Console.readLine());
    }
}
