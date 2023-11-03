package domain;

import constant.ConstantNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto() {
        List<Integer> winningNumbers = pickUniqueNumbersInRange(
                ConstantNumber.MINIMUM_WINNING_NUMBER.get(),
                ConstantNumber.MAXIMUM_WINNING_NUMBER.get(),
                ConstantNumber.WINNING_NUMBER_COUNT.get()
        );
        this.lotto = new Lotto(winningNumbers);
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
