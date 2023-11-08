package lotto.domain;


import lotto.constant.LottoRank;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);

        this.numbers = copiedNumbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateIsProperSize(numbers);
        LottoValidator.validateDuplicatedNumber(numbers);
        LottoValidator.validateRangeOfNumber(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public LottoRank matching(Lotto winningLotto, int bonusNumber) {
        int sameCount = matching(winningLotto);
        boolean isBonus = contains(bonusNumber);

        return LottoRank.getRank(sameCount, isBonus);
    }

    private int matching(Lotto winninglotto) {
        return (int) winninglotto.numbers.stream()
                .filter(this::contains)
                .count();
    }

    @Override
    public String toString() {
        String joinedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", joinedNumbers);
    }
}
