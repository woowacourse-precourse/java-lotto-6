package lotto.util;

import static lotto.util.ErrorMessage.*;

import java.util.List;

public class NumbersValidator { //검증 메소드들을 모아 놓은 클래스

    private static final int TOTAL_LOTTO_NUMBER = 6;
    public static final int RANDOM_NUMBER_MIN_VALUE = 1;
    public static final int RANDOM_NUMBER_MAX_VALUE = 45;

    private NumbersValidator() {
    }

    public static void validate(List<Integer> numbers) { //갯수 체크
        if (numbers.size() != TOTAL_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_OF_LOTTO_ISNT_SIX);
        }
    }

    // TODO: 추가 기능 구현
    public static void checkDuplicate(List<Integer> numbers) { //중복 체크
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_CANT_BE_DUPLICATED);
        }
    }

    public static void checkElementsInRange(List<Integer> numbers) { //범위 체크
        if (numbers.stream().anyMatch(number -> number < RANDOM_NUMBER_MIN_VALUE || number > RANDOM_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }


}
