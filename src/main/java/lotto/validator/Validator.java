package lotto.validator;

import java.util.List;

public class Validator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int TOTAL_NUMBER = 6;
    private static final int LOTTO_PRICE = 1000;
    private static String ERROR_MESSAGE = "[ERROR]";
    private static String INPUT_CONTAINS_STRING = " 숫자가 아닌 값이 포함되어 있습니다.";
    private static String INPUT_OVER_MINIMUM = " 로또는 최소 1,000원 부터 구매 가능합니다.";
    private static String INPUT_NOT_MEET_UNIT = " 1,000원 단위로 입력해주세요.";
    private static String DUPLICATE_NUMBERS = "중복된 로또 번호가 존재합니다.";
    private static String CHECK_NUMBERS_COUNT = "로또 번호의 개수는 6개여야 합니다.";
    private static String NUMBERS_IN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateDuplicateNumber(numbers);
        numbers.forEach(Validator::validateLottoNumber);
    }

    public static void validateBonusNumbers(List<Integer> numbers, String bonusNumberString) {
        int bonusNumber = Integer.parseInt(validateNumberString(bonusNumberString));
        validateLottoNumber(bonusNumber);
        validateContainsBonusNumbers(numbers, bonusNumber);
    }

    private static String validateNumberString(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_CONTAINS_STRING);
        }
        return number;
    }

    public static void validateContainsBonusNumbers(List<Integer> numbers, int bonusNumbers) {
        if (numbers.contains(bonusNumbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_NUMBERS);
        }
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != TOTAL_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CHECK_NUMBERS_COUNT);
        }
    }
    private static void validateDuplicateNumber(List<Integer> numbers) {
        long lottoNumbersSize = numbers.stream().distinct().count();
        if (lottoNumbersSize != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_NUMBERS);
        }
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < START_NUMBER || lottoNumber > END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NUMBERS_IN_RANGE);
        }
    }

    public static long validateString(String inputString) {
        if (!inputString.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_CONTAINS_STRING);
        }

        long purchaseAmount = Long.parseLong(inputString);
        validateAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateAmount(long purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_OVER_MINIMUM);
        }

        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_NOT_MEET_UNIT);
        }
    }
}
