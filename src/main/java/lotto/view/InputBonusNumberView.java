package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.InputValueIsNotNumber;

public class InputBonusNumberView {
    private static final Pattern FORMAT = Pattern.compile("\\d+");
    public Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
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
