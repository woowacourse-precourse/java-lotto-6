package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.Config.*;
import static lotto.constant.ErrorMessage.*;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateNotDuplicated(numbers);
        validateAscending(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).toList();
    }

    public static Lotto generate() {
        return new Lotto(
                pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_COUNT)
                        .stream()
                        .sorted()
                        .toList()
        );
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_NOT_MATCHED);
        }
    }

    private void validateNotDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED);
        }
    }

    private void validateAscending(List<Integer> numbers) {
        if (IntStream
                .range(1, numbers.size())
                .anyMatch(index -> numbers.get(index - 1) > numbers.get(index))) {
            throw new IllegalArgumentException(LOTTO_NOT_ASCENDING);
        }
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.stream().anyMatch(lottoNumber -> lottoNumber.number() == number.number());
    }

    public int countMatched(Lotto lotto) {
        return (int) numbers
                .stream()
                .filter(lotto::hasNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
