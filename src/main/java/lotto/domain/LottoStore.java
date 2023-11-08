package lotto.domain;

import java.util.List;

import static lotto.utils.Constants.LOTTO_PRICE;

public class LottoStore {
    private static final String LESS_THAN_MINIMUM_PRICE_EXCEPTION_FORMAT = "로또 구입 금액은 최소 %d원 이상이어야 합니다.";
    private static final String INVALID_PURCHASE_AMOUNT_EXCEPTION_FORMAT = "로또 구입 금액은 %d원 단위어야 합니다.";

    private static final int VALID_REMAINING_AMOUNT = 0;

    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        return lottoGenerator.createLottos(purchaseAmount / LOTTO_PRICE);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format(LESS_THAN_MINIMUM_PRICE_EXCEPTION_FORMAT, LOTTO_PRICE));
        }
        if (isInvalidPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_PURCHASE_AMOUNT_EXCEPTION_FORMAT, LOTTO_PRICE));
        }
    }

    private boolean isInvalidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != VALID_REMAINING_AMOUNT;
    }
}
