package lotto.validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.GameNumberConstants.*;

public class LottoNumberValidator {
    private static final String LOTTO_INPUT_SHOULD_BE_N = "[ERROR] 복권 번호는 %d개 입력해야합니다.";
    private static final String SHOULD_NOT_DUPLICATE = "[ERROR] 복권 번호는 중복되면 안됩니다.";
    private static final String SHOULD_BE_IN_LOTTO_NUMBER_RANGE = "[ERROR] 복권 번호는 %d이상 %d이하 이어야 합니다.";

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() == NUMBER_OF_NUMBERS_TO_MATCH.getValue()) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                LOTTO_INPUT_SHOULD_BE_N,
                NUMBER_OF_NUMBERS_TO_MATCH.getValue())
        );
    }

    public static void validateDuplication(List<Integer> numbers) {
        int deduplicatedNumbersSize = (int) numbers.stream()
                .distinct()
                .count();
        if (deduplicatedNumbersSize == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException(SHOULD_NOT_DUPLICATE);
    }

    public static void validateDuplication(int bonusNumber, List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number.equals(bonusNumber))) {
            throw new IllegalArgumentException(SHOULD_NOT_DUPLICATE);
        }
    }

    public static void validateNumberRangeInLotto(List<Integer> lotto) {
        lotto.stream()
                .forEach(number -> validateLottoNumberRange(number));
    }

    public static void validateLottoNumberRange(int number) {
        if (isInLottoNumberRange(number)) {
            throw new IllegalArgumentException(String.format(
                    SHOULD_BE_IN_LOTTO_NUMBER_RANGE,
                    MIN_LOTTO_NUMBER.getValue(),
                    MAX_LOTTO_NUMBER.getValue()));
        }
    }

    public static boolean isInLottoNumberRange(int number) {
        return (number < MIN_LOTTO_NUMBER.getValue()) || (number > MAX_LOTTO_NUMBER.getValue());
    }
}
