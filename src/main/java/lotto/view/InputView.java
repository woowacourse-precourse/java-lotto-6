package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public Integer purchaseLotto() {
        Integer inputMoney = Integer.parseInt(Console.readLine());
        inputValidator.validateInputMoney(inputMoney);

        return inputMoney;
    }
}
