package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoRandomNumbers {

    private final List<Integer> lottoRandomNumbers;

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;

    public LottoRandomNumbers() {
        this.lottoRandomNumbers = generateLottoNumbers();
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_SIZE);
    }
}
