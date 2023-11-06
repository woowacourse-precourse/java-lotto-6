package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSeller {
    private final int LOTTO_PRICE = 1000;

    public ArrayList<Lotto> sellLotto(int amount) {
        int numberOfLotto = amount / LOTTO_PRICE;

        ArrayList<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoBundle.add(createRandomLotto());
        }

        return lottoBundle;
    }

    public Lotto createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
