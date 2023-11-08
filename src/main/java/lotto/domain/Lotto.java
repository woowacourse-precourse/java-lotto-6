package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.NumberConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberConstants.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    public boolean isAlreadyExistNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto otherLotto) {
        return (int) numbers.stream()
            .filter(otherLotto.numbers::contains)
            .count();
    }

    @Override
    public String toString() {
        String lottoPrintFormat = numbers.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", "));
        return String.format("[%s]", lottoPrintFormat);
    }
}
