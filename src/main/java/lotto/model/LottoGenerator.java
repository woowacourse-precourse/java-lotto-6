package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_PRICE = 1000;

    public ArrayList<Lotto> generateLottoBundle(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException();
        if (amount % LOTTO_PRICE != 0)
            throw new IllegalArgumentException();

        int lottoCount = amount / LOTTO_PRICE;
        ArrayList<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.add(generateRandomLotto());
        }

        return lottoBundle;
    }

    public Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
