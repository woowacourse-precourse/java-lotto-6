package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    private static final int MIN_SIZE = 6;
    private static final int MAX_SIZE = 7;
    private static final String ERROR = "[ERROR] 로또 번호는 ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_MIN_SIZE = ERROR + "6개 입니다.";
    private static final String ERROR_MAX_SIZE = ERROR + "6개, 보너스 번호는 1개 입니다.";
    private static final String ERROR_DUPLICATION = ERROR + "겹치도록 숫자를 입력할 수 없습니다.";

    private LottoNumberValidator() {}

    public static void validate_MIN_SIZE(List<Integer> input) {
        validateBlankException(input);
        validateLottoMIN_Size(input);
        validateNumberDuplication(input);
    }
    public static void validate_MAX_SIZE(List<Integer> input) {
        validateBlankException(input);
        validateLottoMAX_Size(input);
        validateNumberDuplication(input);
    }

    private static void validateBlankException(List<Integer> input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateLottoMIN_Size(List<Integer> input) {
        if (input.size() != MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_MIN_SIZE);
        }
    }
    private static void validateLottoMAX_Size(List<Integer> input) {
        if (input.size() != MAX_SIZE) {
            throw new IllegalArgumentException(ERROR_MAX_SIZE);
        }
    }

    private static void validateNumberDuplication(List<Integer> input) {
        Set<Integer> set = new HashSet<>();
        boolean hasDuplicates = input.stream()
                .anyMatch(n -> !set.add(n));
        if (hasDuplicates) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

}
