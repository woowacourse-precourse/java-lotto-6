package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    public List<Lotto> issue(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getAmount() / LottoConstants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(getLotto());
        }
        return List.copyOf(lottos);
    }

    private Lotto getLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.LOTTO_NUMBERS_SIZE
                )
                .stream().sorted().toList();
        return new Lotto(randomNumbers);
    }
}