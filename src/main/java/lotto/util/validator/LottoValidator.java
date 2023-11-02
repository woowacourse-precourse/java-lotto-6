package lotto.util.validator;

import static lotto.exception.ExceptionMessage.DUPLICATED;
import static lotto.exception.ExceptionMessage.EMPTY;
import static lotto.exception.ExceptionMessage.NOT_NUMBER;
import static lotto.exception.ExceptionMessage.OUT_OF_RANGE;

import java.util.List;
import java.util.regex.Pattern;
import lotto.exception.LottoException;

public class LottoValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    private LottoValidator() {
        // 인스턴스 생성 방지용
    }

    public static void validateNotNull(String input) {
        if(input == null || input.trim().isEmpty()) {
            throw new LottoException(EMPTY);
        }
    }
    public static void validateNumeric(String input) {
        if(!NUMBER_REGEX.matcher(input).matches()) {
            throw new LottoException(NOT_NUMBER);
        }
    }

    public static void validateNotDuplicate(List<Integer> numbers) {
        if(isDuplicated(numbers)) {
            throw new LottoException(DUPLICATED);
        }
    }

    public static void validateInRange(Integer number) {
        if(number < 1 || number > 45) {
            throw new LottoException(OUT_OF_RANGE);
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();
        return uniqueCount < numbers.size();
    }
}
