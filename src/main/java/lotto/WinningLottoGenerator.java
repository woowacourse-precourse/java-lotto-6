package lotto;

import constant.ConstantNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class WinningLottoGenerator {
    public Lotto create() {
        List<Integer> winningNumbers = pickUniqueNumbersInRange(
                ConstantNumber.MINIMUM_WINNING_NUMBER.get(),
                ConstantNumber.MAXIMUM_WINNING_NUMBER.get(),
                ConstantNumber.WINNING_NUMBER_COUNT.get()
                );
        return new Lotto(winningNumbers);
    }
}
