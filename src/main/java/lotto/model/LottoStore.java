package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_COST = 1000;

    private LottoStore() {

    }
    public static List<Lotto> buyLotto(Money lottoPurchaseMoney) {
        List<Lotto> lottos = new ArrayList<>();

        long payableLottoCount = lottoPurchaseMoney.getCountByCost(LOTTO_COST);
        for (int buyCount = 0; buyCount < payableLottoCount; buyCount++) {
            lottos.add(new Lotto(createRandomLottoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> createRandomLottoNumbers() {
        List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randomLottoNumbers.sort(Comparator.naturalOrder());

        return randomLottoNumbers;
    }
}
