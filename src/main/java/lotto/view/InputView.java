package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_SIX_DIGITS_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String budget() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        String budget = Console.readLine();
        validateBlank(budget);

        return budget;
    }

    public String numbers() {
        System.out.println(ENTER_SIX_DIGITS_NUMBERS);
        String numbers = Console.readLine();
        validateBlank(numbers);

        return numbers;
    }

    public String bonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        validateBlank(bonusNumber);

        return bonusNumber;
    }

    public void validateBlank(String purchaseAmount) throws IllegalArgumentException  {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
