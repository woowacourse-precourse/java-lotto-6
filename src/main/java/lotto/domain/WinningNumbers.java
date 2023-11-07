package lotto.domain;

import java.util.List;

public final class WinningNumbers {

    private final Lotto lotto;

    public WinningNumbers(final List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public WinningDetails compare(final Lottos lottos) {
        return lottos.compare(lotto);
    }

    public boolean contains(final BonusNumber bonusNumber) {
        return lotto.contains(bonusNumber.toValue());
    }
}
