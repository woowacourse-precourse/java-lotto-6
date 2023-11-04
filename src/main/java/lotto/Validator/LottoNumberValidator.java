package lotto.Validator;
import java.util.Set;

public class LottoNumberValidator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호를 입력했습니다.";
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개 입력해야 합니다.";

    public static void validateIsNumberInRange(int number, Set<Integer> existingNumbers) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateIsNumberDuplicate(int number, Set<Integer> existingNumbers) {

        if (existingNumbers.contains(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateLottoNumbersCount(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }
}