package lotto.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.RandomNumberProvider;

import java.util.List;

public class oneTo45LottoNumberProvider implements RandomNumberProvider {
    public static final int ONE_TO_45_NUMBER_COUNT = 6;
    public static final int BONUS_NUMBER_INDEX = 5;
    @Override
    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
