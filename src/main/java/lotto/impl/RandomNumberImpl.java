package lotto.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.RandomNumberProvider;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberImpl implements RandomNumberProvider {

    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
    public static final int LOTTO_NUM_COUNT = 6;
    @Override
    public List<Integer> generateRandomNumber() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_NUM_COUNT));
    }

}
