package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.ExceptionMessage.EXCEED_LIMIT;
import static lotto.constants.ExceptionMessage.HAS_LETTER;
import static lotto.constants.ExceptionMessage.IS_NOT_THOUSAND_UNIT;
import static lotto.constants.Notice.ASK_BONUS_NUMBER;
import static lotto.constants.Notice.ASK_PURCHASE_PRICE;
import static lotto.constants.Notice.ASK_WINNING_NUMBERS;

public class InputView {
    private static final int THOUSAND_UNIT = 1000;
    private static final int PURCHASE_LIMIT = 100000;

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
        if (won % THOUSAND_UNIT != 0) {
            throw new IllegalArgumentException(IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private static void validatePurchaseLimit(int won) {
        if (won > PURCHASE_LIMIT) {
            throw new IllegalArgumentException(EXCEED_LIMIT.getMessage());
        }
    }
}
