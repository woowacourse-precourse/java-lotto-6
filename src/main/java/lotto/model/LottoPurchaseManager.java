package lotto.model;

import static lotto.enums.ErrorMessage.ACCOUNT_UNIT_ERROR;
import static lotto.enums.ErrorMessage.LESS_NUM_ERROR;
import static lotto.enums.ErrorMessage.NEGATIVE_NUM_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoNumberGenerator;


public class LottoPurchaseManager {

    private final int purchaseAmount;
    private final int PurchaseCount;
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public LottoPurchaseManager(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.PurchaseCount = purchaseAmount / 1000;
    }

    public void generateLottos() {
        for (int i = 0; i < PurchaseCount; i++) {
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
        return PurchaseCount;
    }

    private void validate(int purchaseAmount) throws IllegalArgumentException {
        validateNegativeNum(purchaseAmount);
        validateLessAccount(purchaseAmount);
        validateAmountUnit(purchaseAmount);
    }

    private void validateNegativeNum(int purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR.getMessage());
        }
    }

    private void validateLessAccount(int purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException(LESS_NUM_ERROR.getMessage());
        }
    }

    private void validateAmountUnit(int purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000!=0) {
            throw new IllegalArgumentException(ACCOUNT_UNIT_ERROR.getMessage());
        }
    }
}
