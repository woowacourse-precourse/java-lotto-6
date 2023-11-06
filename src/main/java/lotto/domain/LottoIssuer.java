package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoIssuer {

    public List<Lotto> issue(PurchaseAmount purchaseAmount) {
        int lottoCount = getLottoCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(getLotto());
        }
        return List.copyOf(lottos);
    }

    private int getLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / LottoConstants.LOTTO_PRICE;
    }

    private Lotto getLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.LOTTO_NUMBERS_SIZE).stream().sorted().toList();
        return new Lotto(randomNumbers);
    }
}
