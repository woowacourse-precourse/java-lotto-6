package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final List<Lotto> lottoList = new ArrayList<>();

    public Buyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseLotto();
    }

    private void purchaseLotto() {
        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++) {
            generateLotto();
        }
    }

    private void generateLotto() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        lottoList.add(new Lotto(numbers));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getNumberOfLotto() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
