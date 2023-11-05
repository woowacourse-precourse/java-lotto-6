package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.constants.LottoConstants;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 %d개여야 한다."
                    .formatted(LottoConstants.LOTTO_NUMBERS_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        long numbersSizeWithValidRange = numbers.stream()
                .filter(number ->
                        LottoConstants.MIN_LOTTO_NUMBER <= number && number <= LottoConstants.MAX_LOTTO_NUMBER)
                .count();
        if (numbers.size() != numbersSizeWithValidRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 %d이상 %d이하여야 한다."
                    .formatted(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER));
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 달라야 한다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
