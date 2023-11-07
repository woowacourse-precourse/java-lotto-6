package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void generateLotto(int purchasePrice) {
        int purchaseCount = purchasePrice / ONE_LOTTO_PRICE;

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> randomNumbers = pickRandomNumbers();
            keepLottoInStorage(randomNumbers);
        }
    }

    private static void keepLottoInStorage(List<Integer> randomNumbers) {
        Lotto newLotto = new Lotto(randomNumbers);
        LottoStorage.addLotto(newLotto);
    }

    private static List<Integer> pickRandomNumbers() {
        return Randoms
                .pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
