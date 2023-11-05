package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DrawMachine {

    public List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value(), Rule.LOTTO_NUMBERS_DIGITS.value());
    }

//    private Integer bonusNumber() {
//        return Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value(), Rule.BONUS_NUMBER_DIGITS.value()).get(0);
//    }
}
