package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.LottoConfig.LOTTO_PRICE;

public class LottoModel {
    private int inputPrice;
    private int purchasedCount;

    public void setInputPrice(int price) {
        this.inputPrice = price;
    }

    public void calcPurchasedCount() {
        this.purchasedCount = this.inputPrice / LOTTO_PRICE;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }

    public List<Lotto> getPurchasedLotto(int count) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }
}
