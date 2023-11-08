package lotto.model;

import static lotto.constant.NumberConstant.LOTTO_PRICE_UNIT;
import static lotto.enums.ErrorMessage.ACCOUNT_UNIT_ERROR;
import static lotto.enums.ErrorMessage.LESS_NUM_ERROR;
import static lotto.enums.ErrorMessage.NEGATIVE_NUM_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoNumberGenerator;


public class LottoPurchaseManager {

    private static final int INITIAL_VALUE = 0;
    private static final int ZERO = 0;
    private final int purchaseAmount;
    private final int purchaseCount;

    private List<Lotto> lottos = new ArrayList<Lotto>();

    public LottoPurchaseManager(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseAmount / LOTTO_PRICE_UNIT;
    }

    public void generateLottos() {
        for (int i = INITIAL_VALUE; i < purchaseCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    private void validate(int purchaseAmount) throws IllegalArgumentException {
        validateNegativeNum(purchaseAmount);
        validateLessAccount(purchaseAmount);
        validateAmountUnit(purchaseAmount);
    }

    private void validateNegativeNum(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR.getMessage());
        }
    }

    private void validateLessAccount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException(LESS_NUM_ERROR.getMessage());
        }
    }

    private void validateAmountUnit(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % LOTTO_PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(ACCOUNT_UNIT_ERROR.getMessage());
        }
    }
}
