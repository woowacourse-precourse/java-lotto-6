package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public List<List<Integer>> generateLottoNumbers(int lottoQuantity) {
        List<List<Integer>> allRandomLottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
            allRandomLottoNumbers.add(randomLottoNumbers);
        }
        return allRandomLottoNumbers;
    }
}
