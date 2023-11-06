package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoMachine {

    private int purchasedLottoCount;

    public RandomLottoMachine(int purchasedLotto) {
        purchasedLottoCount = purchasedLotto / 1000;
    }

    public List<Lotto> getRandomLottoList() {
        List<Lotto> randomNumbers = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> randomNumberForSort = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));

            randomNumbers.add(new Lotto(randomNumberForSort));
        }
        return randomNumbers;
    }

    public int getPurchasedLottoCount() {
        return purchasedLottoCount;
    }
}
