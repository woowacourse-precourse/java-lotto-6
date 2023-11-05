package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.GameRules;

import java.util.List;

public class NumberPickMachine {
    private NumberPickMachine() {
    }

    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue(), GameRules.NUMBERS_SIZE.getValue());
    }
}
