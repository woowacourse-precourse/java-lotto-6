package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buyLotto(int purchaseAmount) {
        int size = purchaseAmount / LOTTO_PRICE;
        return createLottos(size);
    }

    private static List<Lotto> createLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
