package lotto;

import static lotto.constant.Constant.LOTTO_CNT;
import static lotto.constant.Constant.LOTTO_MAX_VALUE;
import static lotto.constant.Constant.LOTTO_MIN_VALUE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        // TODO 에러메시지 만들기
        if (!isRightSize(numbers.size())) {
            throw new IllegalArgumentException();
        }

        if (!isExistDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }

        if (!isInRangeLottoNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRightSize(int size) {
        return size == LOTTO_CNT;
    }

    private boolean isExistDuplicateNumber(List<Integer> numbers) {

        Set<Integer> setForDuplication = new HashSet<>();
        for (int number : numbers) {
            if (setForDuplication.contains(number)) {
                return false;
            }
            setForDuplication.add(number);
        }
        return true;
    }

    private boolean isInRangeLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE);
    }

    public static Lotto issueLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
