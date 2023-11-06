package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.ValidationManager;

public class LottoPlayer {

    private final int purchaseMoney;
    private final int numberOfLottoTickets;

    public LottoPlayer(String purchaseMoney) {
        ValidationManager.validateInput(purchaseMoney);
        validatePurchaseMoney(purchaseMoney);

        this.purchaseMoney = Integer.parseInt(purchaseMoney);
        this.numberOfLottoTickets = calculateNumberOfLottoTickets();
    }

    public int getNumberOfLottoTickets() {
        return numberOfLottoTickets;
    }

    private int calculateNumberOfLottoTickets() {
        return purchaseMoney / Constant.LOTTO_PRICE;
    }


    private void validatePurchaseMoney(String purchaseMoney) {
        if (isNotDivisibleWithLottoPrice(purchaseMoney)) {
            throw new IllegalStateException(ErrorMessage.INVALID_INPUT_PURCHASE_MONEY.getMessage());
        }
    }

    private boolean isNotDivisibleWithLottoPrice(String purchaseMoney) {
        return Integer.parseInt(purchaseMoney) % Constant.LOTTO_PRICE != 0;
    }


}
