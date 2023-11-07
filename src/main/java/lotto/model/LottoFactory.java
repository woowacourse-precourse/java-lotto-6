package lotto.model;

import static lotto.Constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.Constants.Constants.LOTTO_PRICE;
import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;

public class LottoFactory {

    public List<Lotto> generateLottos(final int purchaseAmount) {
        final int purchasedCount = getPurchasedCount(purchaseAmount);

        final List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchasedCount; count++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER,
            LOTTO_NUMBER_COUNT);
    }

    private int getPurchasedCount(final int purchaseAmount) {
        validateLotto(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validateLotto(final int purchaseAmount) {
        validatePurchaseAmountPositive(purchaseAmount);
        validatePurchaseAmountUnit(purchaseAmount);
    }

    private void validatePurchaseAmountPositive(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new LottoException(PURCHASE_AMOUNT_NOT_POSITIVE);
        }
    }

    private void validatePurchaseAmountUnit(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new LottoException(PURCHASE_AMOUNT_NOT_PRICE_UNIT);
        }
    }

}