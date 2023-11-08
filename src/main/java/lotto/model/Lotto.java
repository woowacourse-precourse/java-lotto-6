package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.constant.Number;
import lotto.constant.ValidatorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder()); // 오름차순 정렬
    }

    private void validate(List<Integer> numbers) {
        validateIsNull(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public static Lotto createLotto() {
        List<Integer> result = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Number.MIN_NUMBER,
                Number.MAX_NUMBER,
                Number.LOTTO_SIZE
        ));

        return new Lotto(result);
    }

    public Rank getRank(Lotto winNumbers, Bonus bonus) {
        return Rank.lottoRank(getCorrectCount(winNumbers), bonus.matchBonus(this));
    }

    public String getLottoNumber() {
        return this.numbers
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private int getCorrectCount(Lotto winNumbers) {
        return (int) numbers.stream()
                .filter(winNumbers::contains)
                .count();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Number.LOTTO_SIZE) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_DUPLICATE);
        }
    }

    private void validateIsNull(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_IS_NULL);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream()
                .allMatch(element -> element >= Number.MIN_NUMBER && element <= Number.MAX_NUMBER)
        ) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_RANGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
