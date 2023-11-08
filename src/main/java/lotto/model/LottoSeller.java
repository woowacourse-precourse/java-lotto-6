package lotto.model;

import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ErrorCode;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;

public class LottoSeller {
    private static final int COST_PER_LOTTO = 1000;
    
    public static Lottos sellLotto(int purchaseAmount, LottoNumbersGenerator lottoNumbersGenerator) {
        int count = calculateCountByPurchaseAmount(purchaseAmount);
        return issueLottos(count, lottoNumbersGenerator);
    }

    private static Lottos issueLottos(int count, LottoNumbersGenerator lottoNumbersGenerator) {
        LottoGenerator lottoGenerator = new LottoGenerator(lottoNumbersGenerator);
        return lottoGenerator.generateLottos(count);
    }

    private static int calculateCountByPurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / COST_PER_LOTTO;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        validatePurchaseAmountValue(purchaseAmount);
        validatePurchaseAmountRange(purchaseAmount);
    }

    private static void validatePurchaseAmountValue(int purchaseAmount) {
        if (purchaseAmount % COST_PER_LOTTO != 0) {
            throw new CustomIllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_INVALID_VALUE);
        }
    }

    private static void validatePurchaseAmountRange(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new CustomIllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_OUT_OF_RANGE);
        }
    }
}
