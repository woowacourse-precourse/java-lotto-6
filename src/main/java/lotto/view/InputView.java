package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.inputvalidator.PriceInputValidate;

public class InputView {
    private static final PriceInputValidate priceInputValidate = new PriceInputValidate();

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        priceInputValidate.validate(userInput);

        return Integer.parseInt(userInput);
    }

}
