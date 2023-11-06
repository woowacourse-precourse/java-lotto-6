package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.RangeException;

import java.util.regex.Pattern;

public class InputBonus {

    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int MIN = 1;
    private static final int MAX = 45;

    private int getBonus() {
        System.out.println(INPUT_BONUS_MESSAGE);
        String bonus = Console.readLine();
        System.out.println();
        validate(bonus);
        validateRange(bonus);
        return Integer.parseInt(bonus);
    }

    private void validate(String bonus) {
        if (!Pattern.compile("\\d+").matcher(bonus).matches()) {
            throw new IllegalArgumentException();
        }
    }
    private void validateRange(String bonus) {
        if (Integer.parseInt(bonus) < MIN || Integer.parseInt(bonus) > MAX) {
            throw new RangeException();
        }
    }
}
