package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final Integer LOTTO_NUMBERS_COUNT = 6;
    private static final Integer MINIMUM_LOTTO_RANGE = 1;
    private static final Integer MAXIMUM_LOTTO_RANGE = 45;

    // TODO: 인스턴스 변수 추가 불가 X.
    // TODO: 패키지 변경 가능 O.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 접근제한자 private 변경 불가 X.
    private void validate(List<Integer> numbers) {
        if (!(isMatchedCount(numbers) && isInNumberRange(numbers) && hasNotDuplicates(numbers))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMatchedCount(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBERS_COUNT;
    }

    private boolean isInNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number ->
                        (number >= MINIMUM_LOTTO_RANGE && number <= MAXIMUM_LOTTO_RANGE));
    }

    private boolean hasNotDuplicates(List<Integer> numbers){
        return numbers.size() == Set.of(numbers).size();
    }


    // todo: OUTPUT에서 사용. 다른 방법 찾아보기.
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

}
