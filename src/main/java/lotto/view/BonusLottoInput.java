package lotto.view;

import java.util.List;

import lotto.exception.BonusNumException;

public class BonusLottoInput {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String BONUS_LOTTO_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int bonusLottoInput() {
        System.out.println(BONUS_LOTTO_MESSAGE);
        String number = UserInput.userInput();
        int num = validateBonus(number);
        return num;
    }

    public static int validateBonus(String number) {
        try {
            int num = validateInt(number);
            validateRange(num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + System.lineSeparator());
            return bonusLottoInput();
        }
        return Integer.parseInt(number);
    }

    public static int validateInt(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            BonusNumException.BonusIntException();
        }
        return Integer.parseInt(number);
    }

    public static void validateRange(int num) {
        if (num < MIN || num > MAX) {
            BonusNumException.BonusRangeException();
        }
    }

}
