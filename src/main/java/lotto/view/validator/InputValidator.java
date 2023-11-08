package lotto.view.validator;

import lotto.util.InputUtil;

import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class InputValidator {

    private InputValidator() {

    }

    public static void validatePurchaseAmountInput(String input) {
        validateIsEmpty(input);
        validateIsDigit(input);
        validatePurchaseUnit(input);
    }

    private static void validatePurchaseUnit(String input) {
        if (parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위이어야 합니다.");
        }
    }

    public static void validateBonusNumberInput(String input) {
        validateIsEmpty(input);
        validateIsDigit(input);
        validateLottoNumberRange(input);
    }

    private static void validateIsDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수이어야 합니다.");
        }
    }

    private static boolean isDigit(String input) {
        try {
            parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validateLottoNumberRange(String input) {
        if (parseInt(input) < 1 || parseInt(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 각각의 당첨 번호는 1~45 범위의 정수이어야 합니다.");
        }
    }

    public static void validateLottoNumberInput(String input) {
        validateIsEmpty(input);
        validateIsRightFormat(input);
        List<Integer> lottoNumbers = InputUtil.convertToList(input);
        validateLottoNumbersLength(lottoNumbers);
        validateIsNumberDuplicate(lottoNumbers);
    }

    private static void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateIsRightFormat(String input) {
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 쉼표(,)를 기준으로 구분되어야 합니다.");
        }
    }

    private static boolean isRightFormat(String input) {
        String regex = "^(\\d+,)*\\d+$";
        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }

    private static void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 총 길이는 6이어야 합니다.");
        }
    }

    private static void validateIsNumberDuplicate(List<Integer> numbers) {
        if (isNumberDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 각 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private static boolean isNumberDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
