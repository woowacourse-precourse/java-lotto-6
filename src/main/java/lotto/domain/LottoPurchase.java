package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.utils.StringUtil;

public class LottoPurchase {
    private final int amount;

    private LottoPurchase(int amount) {
        validatePositive(amount);
        validateThousand(amount);
        this.amount = amount;
    }

    public static LottoPurchase valueOf(int amount) {
        return new LottoPurchase(amount);
    }

    public static LottoPurchase valueOf(String stringAmount) {
        return LottoPurchase.valueOf(StringUtil.stringToInt(stringAmount));
    }

    public LottoTickets generateLottoTickets() {
        return LottoTickets.createBy(getNumberOfTickets());
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfTickets() {
        return amount / 1000;
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        }
    }

    private void validateThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_THOUSAND_INPUT_MESSAGE.getMessage());
        }
    }
}
