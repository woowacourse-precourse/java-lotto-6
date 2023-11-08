package lotto.view;

import static lotto.constants.Constant.DELIMITER;
import static lotto.constants.Constant.MINIMUM_LOTTO_NUMBER;
import static lotto.constants.Constant.MINIMUM_LOTTO_PRICE_UNIT;
import static lotto.constants.Constant.WHITESPACE_REGEX;
import static lotto.constants.Message.CONTAINS_WHITESPACE;
import static lotto.constants.Message.ENDS_WITH_DELIMITER;
import static lotto.constants.Message.INPUT_BONUS_NUMBER;
import static lotto.constants.Message.INPUT_PURCHASE_AMOUNT;
import static lotto.constants.Message.INPUT_WINNING_LOTTO;
import static lotto.constants.Message.INVALID_NUMBER_FORMAT;
import static lotto.constants.Message.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.Message.ZERO_OR_NEGATIVE_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

public class InputView {
    private static final Integer ZERO_REMAINDER = 0;

    public int askPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT);
                String purchaseAmount = Console.readLine();
                validatePurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateNotBlank(purchaseAmount);
        validateInputIsNumeric(purchaseAmount);
        validateInputIsPositiveNumber(purchaseAmount);
        validateInputIsMultipleOfThousand(purchaseAmount);
    }

    public WinningNumbers askWinningNumbers() {
        Lotto lotto = askWinningLotto();
        while (true) {
            try {
                int bonusNumber = askBonusNumber();
                return new WinningNumbers(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto askWinningLotto() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_LOTTO);
                String numbers = Console.readLine();
                validateNumbers(numbers);
                return new Lotto(Stream.of(numbers.split(DELIMITER))
                        .map(Integer::parseInt)
                        .toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int askBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        validateNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public void validateNumbers(String numbers) {
        validateNotEndWithDelimiter(numbers);
        List.of(numbers.split(DELIMITER)).forEach(this::validateNumber);
    }

    public void validateNumber(String number) {
        validateNotBlank(number);
        validateInputIsNumeric(number);
        validateInputIsPositiveNumber(number);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException(CONTAINS_WHITESPACE);
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile(WHITESPACE_REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateInputIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }

    private void validateInputIsPositiveNumber(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount < MINIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ZERO_OR_NEGATIVE_NUMBER);
        }
    }

    private void validateInputIsMultipleOfThousand(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % MINIMUM_LOTTO_PRICE_UNIT != ZERO_REMAINDER) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

    private void validateNotEndWithDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ENDS_WITH_DELIMITER);
        }
    }
}
