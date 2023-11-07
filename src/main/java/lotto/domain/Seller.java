package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    public List<Lotto> sellLotto(final int payment) {
        validatePayment(payment);
        List<Lotto> lottos = new ArrayList<>();

        int quantity = payment / LottoSetting.PRICE.getValue();
        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    private void validatePayment(final int payment) {
        final int PRICE = LottoSetting.PRICE.getValue();
        if (payment % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 "
                    + PRICE + "원으로 나누어 떨어져야 합니다.");
        }
    }
}
