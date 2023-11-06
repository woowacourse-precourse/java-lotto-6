package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.util.Utils;

import static lotto.util.LottoConstants.*;

public class Service {

    public void buyLotto(Buyer buyer) {
        int count = buyer.getPurchaseAmount() / MIN_UNIT;
        while (count > 0) {
            Lotto lotto = generateLottoNumbers();
            buyer.buyLotto(lotto);
            count--;
        }
    }

    private Lotto generateLottoNumbers() {
        return new Lotto(Utils.randomUniqueNumbers(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_SIZE));
    }


}
