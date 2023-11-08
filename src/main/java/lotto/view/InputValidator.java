package lotto.view;

import java.util.regex.Pattern;

final class InputValidator {
    private static final Pattern NON_SPACED = Pattern.compile("^[\\S]+$");
    private static final Pattern ONLY_NUMBERS = Pattern.compile("^[0-9]+$");
    private static final Pattern ZERO_LEADING_NUMBERS = Pattern.compile("^[0][0-9]*$");
    private static final Pattern NON_PARSABLE_NUMBERS = Pattern.compile("^[1-9][0-9]{9,}$");
    private static final Pattern LOTTO_NUMBERS = Pattern.compile("^([1-9][0-9]{0,1})(,[1-9][0-9]{0,1}){5}$");

    private InputValidator() {
    }

    static void validateNonSpaced(String userInput) {
        if (!NON_SPACED.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    static void validateNonZeroLeadingParsableNumber(String userInput) {
        if (!ONLY_NUMBERS.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        if (ZERO_LEADING_NUMBERS.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하는 숫자는 입력할 수 없습니다.");
        }
        if (NON_PARSABLE_NUMBERS.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 10자리 이상의 숫자는 입력할 수 없습니다.");
        }
    }

    static void validateLottoNumbersPattern(String userInput) {
        if (!LOTTO_NUMBERS.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 쉼표로 구분해서 6개 입력해야 합니다.");
        }
    }

    static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1_000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (purchaseAmount > 100_000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 100,000원을 초과할 수 없습니다.");
        }
        if (purchaseAmount % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    static void validateLottoNumber(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
        }
    }
}
