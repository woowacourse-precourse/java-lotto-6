package lotto.utils;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String ERROR = "[ERROR] ";
    private static final String NUMBER = "숫자를 입력해주세요.";
    private static final String BLANK = "입력이 공백입니다.";
    private static final String INVALID_PRICE = "1000원 단위의 수를 입력해주세요.";
    private static final String INVALID_SIZE = "6개의 당첨 번호를 입력해주세요.";
    private static final String INVALID_RANGE = "1부터 45까지의 번호만 입력해주세요.";
    private static final String DUPLICATED = "당첨 번호에 중복된 숫자가 존재합니다.";
    private static final String INVALID_LOTTO_FORMAT = "숫자와 쉼표를 이용해 당첨 번호를 입력해주세요.";
    private static final String INVALID_BONUS_NUMBER = "입력한 당첨 번호 중 보너스 번호가 이미 존재합니다.";

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final Pattern LOTTO_PATTERN = Pattern.compile("^(\\d*,)*\\d*$");

    public static void checkMoney(String input) {
        checkIsBlank(input);
        checkIsNumber(input);
        checkPriceFormat(input);
    }

    public static void checkLotto(List<Integer> input) {
        checkLottoSizeIsSix(input);
        checkLottoIsInRange(input);
        checkLottoNumberIsDuplicated(input);
    }

    public static void checkBonusNumber(List<Integer> lotto, String bonusNumber) {
        checkIsBlank(bonusNumber);
        checkIsNumber(bonusNumber);
        checkRange(bonusNumber);
        checkBonusNumberInLotto(lotto, StringConvertor.stringToInt(bonusNumber));
    }

    private static void checkIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR + NUMBER);
        }
    }

    private static void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR + BLANK);
        }
    }

    private static void checkPriceFormat(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR + INVALID_PRICE);
        }
    }

    private static void checkRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ERROR + INVALID_RANGE);
        }
    }

    private static void checkBonusNumberInLotto(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + INVALID_BONUS_NUMBER);
        }
    }

    private static void checkLottoSizeIsSix(List<Integer> input) {
        if (input.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR + INVALID_SIZE);
        }
    }

    private static void checkLottoIsInRange(List<Integer> input) {
        if (input.stream().anyMatch(number -> number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException(ERROR + INVALID_RANGE);
        }
    }

    private static void checkLottoNumberIsDuplicated(List<Integer> input) {
        if (input.stream().distinct().count() != input.size()) {
            throw new IllegalArgumentException(ERROR + DUPLICATED);
        }
    }

    public static void checkLottoNumberFormat(String input) {
        if (!LOTTO_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR + INVALID_LOTTO_FORMAT);
        }
    }

}
