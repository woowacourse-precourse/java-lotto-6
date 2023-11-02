package lotto.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.RandomNumberProvider;

import java.util.List;

public class LottoNumberProvider implements RandomNumberProvider {
    @Override
    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
