package domain;

import util.LottoRandomUtil;

import java.util.List;

public class WinningLotto {
    public final int bonusNumber;
    private final Lotto lotto;

    {
        bonusNumber = new LottoRandomUtil().getWinningNumber();
    }

    public WinningLotto() {
        this.lotto = new Lotto();
    }

    WinningLotto(List<Integer> numbers) {
        lotto = new Lotto(numbers);
    }

    int size() {
        return lotto.getNumbers().size();
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
