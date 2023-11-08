package lotto.exception;

import java.util.List;
import java.util.stream.IntStream;

public class LottoException {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_FINISH = 45;
    private static final String IS_DUPLICATE_MESSAGE = " 로또 번호에 중복이 있습니다.";
    private static final String IS_SIZE_MESSAGE = " 로또 번호가 6개가 아닙니다.";
    private static final String IS_RIGHT_RANGE_MESSAGE = " 로또 번호는 1부터 45 사이의 숫자로만 구성되어야 합니다.";
    private static final String IS_NOT_ASCENDING_MESSAGE = " 로또 번호가 오름차순이 아닙니다";
    private static final String ERROR = "[ERROR]";

    public LottoException(List<Integer> input) {
        isSize(input);
        isDuplicate(input);
        isAscending(input);
        isRightRange(input);
    }

    public void isDuplicate(List<Integer> input) {
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR + IS_DUPLICATE_MESSAGE);
        }
    }

    public void isSize(List<Integer> input) {
        if (input.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR + IS_SIZE_MESSAGE);
        }
    }

    public void isRightRange(List<Integer> input) {
        if (input.stream().anyMatch(i -> i < LOTTO_NUM_START || i > LOTTO_NUM_FINISH)) {
            throw new IllegalArgumentException(ERROR + IS_RIGHT_RANGE_MESSAGE);
        }

    }

    public void isAscending(List<Integer> input) {
        boolean isAscending = IntStream.range(LOTTO_NUM_START, input.size())
                .allMatch(i -> input.get(i - 1) < input.get(i));
        if (!isAscending) {
            throw new IllegalStateException(ERROR + IS_NOT_ASCENDING_MESSAGE);
        }
    }
}
