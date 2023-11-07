package lotto.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrice;
import lotto.domain.lotto.LottoRule;

public class LottoStore {
    public List<Lotto> createLottos(int purchaseAmount) {
        int lottoCount = LottoPrice.THOUSAND_WON.calcLottoCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(LottoRule.MIN_RANGE, LottoRule.MAX_RANGE, LottoRule.LENGTH);

            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
