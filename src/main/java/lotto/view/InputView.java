package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.ExceptionMessage.HAS_LETTER;
import static lotto.constants.ExceptionMessage.IS_EXCESS_MAX_LIMIT;
import static lotto.constants.ExceptionMessage.IS_NOT_THOUSAND_UNIT;
import static lotto.constants.ExceptionMessage.IS_UNDER_MIN_LIMIT;
import static lotto.constants.Notice.ASK_BONUS_NUMBER;
import static lotto.constants.Notice.ASK_PURCHASE_PRICE;
import static lotto.constants.Notice.ASK_WINNING_NUMBERS;

public class InputView {
    private static final int THOUSAND_UNIT = 1000;
    private static final int CHANGE = 0;
    private static final int PURCHASE_MIN_LIMIT = 1000;
    private static final int PURCHASE_MAX_LIMIT = 100000;

    public static int askPurchaseAmount() throws IllegalArgumentException {
        System.out.println(ASK_PURCHASE_PRICE.getMessage());
        String input = readLine();
        validateType(input);
        int won = Integer.parseInt(input);
        validateThousandUnit(won);
        validatePurchaseLimit(won);
        return won;
    }

    public static String askWinningNumbers() {
        System.out.println();
        System.out.println(ASK_WINNING_NUMBERS.getMessage());
        return readLine();
    }

    public static String askBonusNumber() {
        System.out.println();
        System.out.println(ASK_BONUS_NUMBER.getMessage());
        return readLine();
    }

    private static void validateType(String input) {
        if (hasLetter(input)) {
            throw new IllegalArgumentException(HAS_LETTER.getMessage());
        }
    }

    private static boolean hasLetter(String input) {
        return input.chars()
                .anyMatch(c -> !Character.isDigit(c));
    }

    private static void validateThousandUnit(int won) {
        if (won % THOUSAND_UNIT != CHANGE) {
            throw new IllegalArgumentException(IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private static void validatePurchaseLimit(int won) {
        if (won > PURCHASE_MAX_LIMIT) {
            throw new IllegalArgumentException(IS_EXCESS_MAX_LIMIT.getMessage());
        }
        if (won < PURCHASE_MIN_LIMIT) {
            throw new IllegalArgumentException(IS_UNDER_MIN_LIMIT.getMessage());
        }
    }
}
