package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.ErrorMessages;

import java.util.function.Supplier;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_SIX_DIGITS_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public String ask(Supplier<String> input) throws IllegalArgumentException {
//        System.out.println();
        String result = input.get();
        validateBlank(result);

        return result;
    }

    private void validateBlank(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.NO_CONTENT.value());
        }
    }

    public Supplier<String> budget() {
        return () -> {
            System.out.println(ENTER_PURCHASE_AMOUNT);
            return Console.readLine();
        };
    }

    public Supplier<String> mainNumbers() {
        System.out.println();
        return () -> {
            System.out.println(ENTER_SIX_DIGITS_NUMBERS);
            return Console.readLine();
        };
    }

    public Supplier<String> bonusNumber() {
        System.out.println();
        return () -> {
            System.out.println(ENTER_BONUS_NUMBER);
            return Console.readLine();
        };
    }
}
