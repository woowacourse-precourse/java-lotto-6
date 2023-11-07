package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    public static final int SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = sort(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public int matchWinningLottoCount(final WinningLotto winningLotto) {
        int matchCount = 0;

        for (Integer number : numbers) {
            matchCount += (int) winningLotto.getNumbers().stream().filter(winningNumber -> winningNumber.equals(number))
                    .count();
        }

        return matchCount;
    }

    public boolean hasBonusNumber(final BonusNumber bonusNumber) {
        return numbers.stream().anyMatch(i -> i.equals(bonusNumber.getNumber()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}