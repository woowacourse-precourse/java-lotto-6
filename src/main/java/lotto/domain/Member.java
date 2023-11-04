package lotto.domain;

import lotto.domain.validation.MemberValidationHandler;

public class Member {
    private int lottoCount;

    public int buyLotto(int lottoPurchaseAmount) {
        validationLottoPurchaseAmount(lottoPurchaseAmount);
        return lottoCount = computedLottoCount(lottoPurchaseAmount);
    }

    private void validationLottoPurchaseAmount(int lottoPurchaseAmount) {
        MemberValidationHandler.validationLottoPurchaseAmountUnit(lottoPurchaseAmount);
        MemberValidationHandler.validationRangeLottoCount(lottoPurchaseAmount);
    }

    private int computedLottoCount(int lottoPurchaseAmount) {
        return Math.floorDiv(lottoPurchaseAmount, MemberValidationHandler.LOTTO_PURCHASE_UNIT);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
