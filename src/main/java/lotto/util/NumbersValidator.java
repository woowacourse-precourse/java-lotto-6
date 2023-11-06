package lotto.util;

import java.util.List;

public class NumbersValidator { //검증 메소드들을 모아 놓은 클래스

    private static final int TOTAL_LOTTO_NUMBER = 6;
    private static final int RANDOM_NUMBER_MIN_VALUE = 1;
    private static final int RANDOM_NUMBER_MAX_VALUE = 45;

    public static void validate(List<Integer> numbers) { //기본적으로 6자인 부분만 확인
        if (numbers.size() != TOTAL_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static void checkDuplicate(List<Integer> numbers) { //중복 체크
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkElementsInRange(List<Integer> numbers) { //범위 체크
        if (numbers.stream().anyMatch(number -> number < RANDOM_NUMBER_MIN_VALUE || number > RANDOM_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException();
        }
    }


}
