package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Buyer;
import lotto.model.Lotto;

import java.util.ArrayList;

public class LottoGameService {
    Buyer buyer = new Buyer();

    public int buyLotto(int paymentAmount) {
        int purchasableLottoCount = getPurchasableLottoCount(paymentAmount);
        for (int i = 0; i < purchasableLottoCount; i++) {
            buyer.addPurchasedLottoList(lottoGenerator());
        }
        buyer.setPurchasedLottoCount(purchasableLottoCount);
        return purchasableLottoCount;
    }

    private int getPurchasableLottoCount(int paymentAmount) {
        if ((paymentAmount % 1000) == 0) {
            return paymentAmount / 1000;
        }
        throw new IllegalArgumentException();
    }

    private Lotto lottoGenerator() {
        ArrayList<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }
        return new Lotto(lotto);
    }

    public ArrayList<Lotto> checkPurchasedLotto() {
        return buyer.getPurchasedLottoList();
    }
}
