package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrice;
import lotto.domain.lotto.LottoRule;

public class LottoStore {
    public List<Lotto> createLottos(int purchaseAmount) {
        int lottoCount = getLottoCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(LottoRule.MIN_RANGE, LottoRule.MAX_RANGE, LottoRule.LENGTH);

            lottos.add(new Lotto(sortNumbers(numbers)));
        }
        return lottos;
    }

    private int getLottoCount(int purchaseAmount){
        int price = LottoPrice.THOUSAND_WON.getPrice();
        return purchaseAmount / price;
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        List<Integer> sortedNumber = new ArrayList<>(numbers);
        Collections.sort(sortedNumber);

        return sortedNumber;
    }

}
