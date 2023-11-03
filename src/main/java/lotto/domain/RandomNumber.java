package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {

    private static final int FROM_LOTTO_RANDOM_NUMBER = 1;
    private static final int TO_LOTTO_RANDOM_NUMBER = 45;
    private static final int COUNT_LOTTO_RANDOM_NUMBER = 6;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(FROM_LOTTO_RANDOM_NUMBER, TO_LOTTO_RANDOM_NUMBER, COUNT_LOTTO_RANDOM_NUMBER);
    }
}
