package lotto.domain;

import static lotto.domain.constant.LottoConstant.LOTTO_PURCHASE_UNIT;

import lotto.domain.validation.MemberValidationHandler;

public class Member {
    private int lottoCount;
    private int lottoPurchaseAmount;

    public Member buyLotto(String lottoPurchaseAmount) {
        validationLottoPurchaseAmount(lottoPurchaseAmount);
        this.lottoPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
        this.lottoCount = computedLottoCount(this.lottoPurchaseAmount);

        return this;
    }

    private void validationLottoPurchaseAmount(String lottoPurchaseAmount) {
        MemberValidationHandler.validationHasText(lottoPurchaseAmount);
        MemberValidationHandler.validationNumeric(lottoPurchaseAmount);
        int convertLottoPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
        MemberValidationHandler.validationLottoPurchaseAmountUnit(convertLottoPurchaseAmount);
        MemberValidationHandler.validationRangeLottoCount(convertLottoPurchaseAmount);
    }

    private int computedLottoCount(int lottoPurchaseAmount) {
        return Math.floorDiv(lottoPurchaseAmount, LOTTO_PURCHASE_UNIT);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }
}
