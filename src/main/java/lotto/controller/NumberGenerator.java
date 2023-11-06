package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Integer> createSixLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
