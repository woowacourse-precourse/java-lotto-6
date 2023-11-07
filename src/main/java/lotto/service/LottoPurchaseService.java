package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseService {
    private static final int LOTTO_PRICE = 1000;
    public List<Lotto> purchaseLotto(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lotto.add(Lotto.generate());
        }
        return lotto;
    }
}
