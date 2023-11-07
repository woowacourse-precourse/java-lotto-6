package lotto.domain;

import lotto.service.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validate(numbers);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    public boolean isContainBonus(int bonus) {
        return numbers.contains(bonus);
    }


}
