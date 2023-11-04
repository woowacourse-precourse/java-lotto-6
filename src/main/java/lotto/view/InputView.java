package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.ExceptionMessage.HAS_LETTER;
import static lotto.constants.ExceptionMessage.IS_NOT_THOUSAND_UNIT;

public class InputView {
    public static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        validateType(input);
        int won = Integer.parseInt(input);
        validateThousandUnit(won);
        return won;
    }

    private static void validateType(String input) {
        if (hasLetter(input)) {
            throw new IllegalArgumentException(HAS_LETTER.getMessage());
        }
    }

    private static boolean hasLetter(String input) {
        return input.chars()
                .anyMatch(Character::isLetter);
    }

    private static void validateThousandUnit(int won) {
        if (won % 1000 != 0) {
            throw new IllegalArgumentException(IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }
}
