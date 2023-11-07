package lotto.model;

import static lotto.Constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.Constants.Constants.LOTTO_PRICE;
import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.ErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.ErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.exception.PurchaseException;

public class LottoShop {

    private final int ZERO = 0;

    public List<Lotto> purchaseLottos(final int purchaseAmount) {
        final int purchasedCount = getPurchasedCount(purchaseAmount);
        return generateLottos(purchasedCount);
    }

    private List<Lotto> generateLottos(int purchasedCount) {
        return IntStream.range(ZERO, purchasedCount)
            .mapToObj(i -> new Lotto(generateNumbers()))
            .toList();
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
        if (purchaseAmount <= ZERO) {
            throw new PurchaseException(PURCHASE_AMOUNT_NOT_POSITIVE);
        }
    }

    private void validatePurchaseAmountUnit(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != ZERO) {
            throw new PurchaseException(PURCHASE_AMOUNT_NOT_PRICE_UNIT);
        }
    }

}