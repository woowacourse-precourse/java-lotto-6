package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.congin.LottoConfing;
import lotto.excption.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfing.LoTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_LENGTH);
        }
        Set<Integer> uniqueSet = new HashSet<>(numbers);
        if (numbers.size() != uniqueSet.size()) {
            throw new IllegalArgumentException("로또 번호에는 중복이 들어갈 수 없습니다.");
        }
    }

    public int countMatching(List<Integer> numbers) {
    return (int) this.numbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public Boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
