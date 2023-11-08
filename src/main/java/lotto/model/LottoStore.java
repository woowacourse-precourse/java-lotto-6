package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private LottoStore() {

    }

    public static List<Lotto> buyLotto(Money lottoPurchaseMoney) {
        List<Lotto> lottos = new ArrayList<>();

        int payableLottoCount = lottoPurchaseMoney.getCountByCost(Constants.LOTTO_UNIT.constants);
        for (int buyCount = 0; buyCount < payableLottoCount; buyCount++) {
            lottos.add(new Lotto(createRandomLottoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER.constants,
                Constants.LOTTO_MAX_NUMBER.constants, Constants.LOTTO_LENGTH.constants).stream().sorted().toList();
    }
}
