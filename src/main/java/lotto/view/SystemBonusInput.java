package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class SystemBonusInput {
    private static final String BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    private static final String BLANK_ERROR = "입력된 값이 없습니다. 다시 입력해주세요.";
    private static final String REGULAR_EXPRESSION = ".*\\d.*";
    private static final String BONUS_NUMBER_INPUT_REQUIRED = "보너스 번호는 숫자 형식입니다. 다시 입력해주세요!";

    public static int readBonusNumber() {
        System.out.println(BONUS_INPUT);
        String pickBonus = Console.readLine();
        try {
            validateBonus(pickBonus);
        } catch (IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
            readBonusNumber();
        }
        return Integer.parseInt(pickBonus);
    }

    public static void validateBonus(String pickBonus) {
        validateNone(pickBonus);
        validateBonusNum(pickBonus);


    }

    public static void validateNone(String pickBonus) {
        if (pickBonus.length() == 0) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public static void validateBonusNum(String pickBonus) {
        String PATTERN = REGULAR_EXPRESSION;
        if (!pickBonus.matches(PATTERN)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INPUT_REQUIRED);
        }
    }
}
