package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.exception.InvalidNumberException;
import lotto.exception.InvalidNumberRangeException;

public class BonusNumberInputView {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int START_NUM_OF_LOTTO = 1;
    private static final int END_NUM_OF_LOTTO = 45;

    public static WinningNumber getWinningNumberWithBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                int bonusNumber = BonusNumberInputView.getBonusNumber();
                return new WinningNumber(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String inputBonusNumber = Console.readLine().trim();
        System.out.println();
        validateIsNumber(inputBonusNumber);
        validateNumberInRange(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private static void validateNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < START_NUM_OF_LOTTO || number > END_NUM_OF_LOTTO) {
            throw new InvalidNumberRangeException();
        }
    }

    private static void validateIsNumber(String input) {
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidNumberException();
        }
    }
}
