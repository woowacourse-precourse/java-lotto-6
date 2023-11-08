package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.LottoNumber;

public class RandomNumbers {
    public List<Integer> draw() {
        return randomNumberPick();
    }

    public List<Integer> randomNumberPick() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER.getNumber(), LottoNumber.MAX_NUMBER.getNumber(),
                LottoNumber.NUMBER_COUNT.getNumber());
    }
}
