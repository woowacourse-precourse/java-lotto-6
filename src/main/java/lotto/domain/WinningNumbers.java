package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.WinningGrade;

import java.util.List;

public final class WinningNumbers {

    private final Lotto lotto;

    public WinningNumbers(final List<Integer> numbers) {
        validate(numbers);
        this.lotto = new Lotto(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_WINNING_NUMBERS.toValue());
        }
    }

    private boolean hasDuplicate(final List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public List<WinningGrade> compare(final Lottos lottos) {
        return lottos.compare(lotto);
    }

    public boolean contains(final BonusNumber bonusNumber) {
        return lotto.contains(bonusNumber.toValue());
    }
}
