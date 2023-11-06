package lotto.model;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(PaymentAmount paymentAmount) {
        int numberOfLotto = computeNumberOfLotto(paymentAmount.getPrice());
        lottos = new ArrayList<>();
    }

    private int computeNumberOfLotto(int price) {
        return price / LOTTO_PRICE;
    }
}
