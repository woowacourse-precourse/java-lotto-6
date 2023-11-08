package lotto.lotto;

import static lotto.error.message.InvalidInputErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.error.message.InvalidInputErrorMessage.PURCHASE_AMOUNT_UNDER_LOTTO_PRICE;
import static lotto.global.Constant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.error.exception.InvalidStateException;

public class LottoVendor {
    public List<Lotto> generateLottos(Integer purchaseAmount) {
        validate(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        Integer remainingLottos = purchaseAmount / LOTTO_PRICE.getNumber();

        while (remainingLottos > 0) {
            lottos.add(Lotto.create());
            remainingLottos--;
        }
        return lottos;
    }

    private void validate(Integer purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE.getNumber()) {
            throw new InvalidStateException(PURCHASE_AMOUNT_UNDER_LOTTO_PRICE.getMessage());
        }
        if (purchaseAmount % LOTTO_PRICE.getNumber() != 0) {
            throw new InvalidStateException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
