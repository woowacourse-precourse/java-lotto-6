package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoMachine {
    private final int RANDOM_MIN = 1;
    private final int RANDOM_MAX = 45;
    private final int RANDOM_COUNT = 6;
    private final int AMOUNT_UNIT = 1000;
    private int purchasedLottoCount;

    public RandomLottoMachine(int purchasedLotto) {
        purchasedLottoCount = purchasedLotto / AMOUNT_UNIT;
    }

    public List<Lotto> getRandomLottoList() {
        List<Lotto> randomNumbers = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> randomNumberForSort = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(RANDOM_MIN, RANDOM_MAX, RANDOM_COUNT));

            randomNumbers.add(new Lotto(randomNumberForSort));
        }
        return randomNumbers;
    }

    public int getPurchasedLottoCount() {
        return purchasedLottoCount;
    }
}
