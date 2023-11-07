package lotto;


import lotto.constant.LottoRank;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.NumericConstant.LOTTO_NUMBER_COUNT;

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

        for (int number : numbers) {
            LottoValidator.validateRangeOfNumber(number);
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
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
        int sameCount = 0;

        for (int number : winninglotto.numbers) {
            if (contains(number)) {
                sameCount++;
            }
        }

        return sameCount;
    }

    @Override
    public String toString() {
        String joinedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", joinedNumbers);
    }
}
