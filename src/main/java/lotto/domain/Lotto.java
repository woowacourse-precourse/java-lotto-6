package lotto.domain;

import java.util.List;
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
    }

    public void sortAscending() {
        //numbers.sort(Comparator.naturalOrder());
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
