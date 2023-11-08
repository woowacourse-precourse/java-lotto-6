package lotto.model;

import static lotto.model.constans.LottoSetting.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoStore {
    private static LottoStore lottoStore;
    private static final int lottoPrice = LOTTO_PRICE.value();

    private LottoStore() {
    }

    public static LottoStore getInstance() {
        if (lottoStore == null) {
            lottoStore = new LottoStore();
        }
        return lottoStore;
    }

    public int calculatePurchasedLottoAmount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    public Lotto issueRandomLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.value(), MAX_LOTTO_NUMBER.value(), LOTTO_SIZE.value());
    }
}
