package domain;

import constant.ConstantNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class WinningLotto {
    private final Lotto lotto;

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
