package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;

    public List<Lotto> inputPurchasePrice(int price) {
        List<Lotto> lottos = new ArrayList<>();

        checkRemain(price);

        while (price > 0) {
            lottos.add(pickLotto());
            price -= LOTTO_PRICE;
        }

        return lottos;
    }

    private void checkRemain(int price) {
        if (0 != price % LOTTO_PRICE) {
            throw new IllegalArgumentException(CustomErrorMessage.CHANGE);
        }
    }

    private Lotto pickLotto() {
        return null;
    }
}
