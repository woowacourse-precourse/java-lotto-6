package domain;

import util.LottoRandomUtil;

import java.util.List;

public class WinningLotto {
    public final int bonusNumber;
    private final Lotto lotto;

    public WinningLotto() {
        this.lotto = new Lotto();
        this.bonusNumber = new LottoRandomUtil().getWinningNumber();
    }

    WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
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

    public int getBonusNumber() {
        return bonusNumber;
    }
}
