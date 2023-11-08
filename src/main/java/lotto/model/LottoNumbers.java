package lotto.model;

import lotto.util.RandomNumberGenerator;
import java.util.Comparator;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(LOTTO_MIN_NUM, LOTTO_MAX_NUM);

    public static List<Integer> setLottoNumbers() {
        List<Integer> lottoNumbers = randomNumberGenerator.generateRandomUniqueNumbers(LOTTO_NUMBER_COUNT);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}
