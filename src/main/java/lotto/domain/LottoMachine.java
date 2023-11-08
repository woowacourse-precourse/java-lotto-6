package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;

public class LottoMachine {

    public static final int PRICE = 1000;

    public List<Lotto> buy(int price) {
        validate(price);

        int amount = price / PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.generateRandom());
        }

        return lottos;
    }

    private void validate(int price) {
        if (price <= 0 || price % PRICE != 0) {
            throw LottoException.of(INVALID_PURCHASE_AMOUNT);
        }
    }
}
