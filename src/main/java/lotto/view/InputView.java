package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.InputValueIsNotNumber;

public class InputView {
    private static final Pattern FORMAT = Pattern.compile("\\d+");
    public Integer getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String input) {
        validateForm(input);
    }

    private void validateForm(String input) {
        if (!FORMAT.matcher(input).matches()) {
            try {
                throw new InputValueIsNotNumber();
            } catch (InputValueIsNotNumber e) {
                throw new RuntimeException(e);
            }
        }
    }
}
