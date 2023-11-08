package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;
import lotto.utils.StringUtil;

public class LottoPurchase {
    private final int amount;

    private LottoPurchase(int amount) {
        validatePositive(amount);
        validatePurchaseRule(amount);
        this.amount = amount;
    }

    public static LottoPurchase valueOf(int amount) {
        return new LottoPurchase(amount);
    }

    public static LottoPurchase valueOf(String stringAmount) {
        return LottoPurchase.valueOf(StringUtil.stringToInt(stringAmount));
    }

    public LottoTickets generateLottoTickets() {
        return LottoTickets.createdByNumber(getNumberOfTickets());
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfTickets() {
        return amount / LottoEnum.PURCHASE_RULE.getValue();
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        }
    }

    private void validatePurchaseRule(int amount) {
        if (amount % LottoEnum.PURCHASE_RULE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_PURCHASE_RULE_INPUT_MESSAGE.getMessage());
        }
    }
}
