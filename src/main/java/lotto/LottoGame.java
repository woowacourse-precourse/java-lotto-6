package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGame {
    private final int lottoStartNumber = 1;
    private final int lottoEndNumber = 45;
    private final int lottoLength = 6;
    private Lotto winningLotto;
    private int BonusNumber;

    public Lotto getLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoStartNumber, lottoEndNumber, lottoLength);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public void setWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public void setBonusNumber(int number) {
        this.BonusNumber = number;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.BonusNumber;
    }
}
