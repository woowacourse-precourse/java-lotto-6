package lotto.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ParseString;

public class InputLottoNumException {
    ParseString parser = new ParseString();
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_NUM_AMMOUNT = 6;
    private static final String REG_INPUT = "[0-9]+";
    private static final String ERROR = "[ERROR] ";

    public void validateAll(String number) {
        validateNumber(number);
        validateNegative(number);
        validateRange(number);
    }

    public void validateBonus(List<Integer> numbers, String number) {
        validateAll(number);
        validateBonusDuplication(numbers, Integer.parseInt(number));
    }

    public void validateLotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
    }

    public void validateException(String[] numbers) {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            validateAll(numbers[i]);
        }
    }

    public void validateLength(List<Integer> lotto) {
        if (lotto.size() != LOTTO_NUM_AMMOUNT) {
            throw new IllegalArgumentException(ERROR + "6개의 숫자를 입력하세요.");
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(ERROR + "중복된 값은 입력할 수 없습니다.");
        }
    }

    public void validateBonusDuplication(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 중복될 수 없습니다.");
        }
    }

    public void validateNumber(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException(ERROR + "숫자만 입력해주세요.");
        }
    }

    public void validateNegative(String number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException(ERROR + "양수만 입력해주세요.");
        }
    }

    public void validateRange(String number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean isNumber(String number) {
        return number.matches(REG_INPUT);
    }

    public boolean isNegative(String number) {
        return parser.parseToInt(number) <= 0;
    }

    public boolean isInRange(String number) {
       return parser.parseToInt(number) >= START_RANGE && parser.parseToInt(number) <= END_RANGE;
    }
}
