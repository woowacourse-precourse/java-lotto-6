package util;

import constant.ConstantNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoRandomUtil {

    public int getWinningNumber() {
        return pickUniqueNumbersInRange(
                ConstantNumber.MINIMUM_WINNING_NUMBER.get(),
                ConstantNumber.MAXIMUM_WINNING_NUMBER.get(),
                1
        ).get(0);
    }

    public List<Integer> getWinningNumbers(int count) {
        return pickUniqueNumbersInRange(
                ConstantNumber.MINIMUM_WINNING_NUMBER.get(),
                ConstantNumber.MAXIMUM_WINNING_NUMBER.get(),
                count
        );
    }
}
