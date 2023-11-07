package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class IssueMachine {

    public List<Integer> lotto() {
        return Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value(), Rule.LOTTO_NUMBERS_DIGITS.value());
    }
}
