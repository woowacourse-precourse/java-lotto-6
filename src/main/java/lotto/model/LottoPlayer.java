package lotto.model;

import static lotto.util.Constant.*;

import lotto.util.ErrorMessage;
import lotto.util.validate.ValidationManager;

public class LottoPlayer {

    private final int purchaseMoney;
    private final int numberOfLottoTickets;

    public LottoPlayer(String purchaseMoney) {
        ValidationManager.validateInput(purchaseMoney);
        validatePurchaseMoney(purchaseMoney);

        this.purchaseMoney = Integer.parseInt(purchaseMoney);
        this.numberOfLottoTickets = calculateNumberOfLottoTickets();
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getNumberOfLottoTickets() {
        return numberOfLottoTickets;
    }

    private int calculateNumberOfLottoTickets() {
        return purchaseMoney / LOTTO_PRICE;
    }


    private void validatePurchaseMoney(String purchaseMoney) {
        if (isNotDivisibleWithLottoPrice(purchaseMoney)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PURCHASE_MONEY.getMessage());
        }
    }

    private boolean isNotDivisibleWithLottoPrice(String purchaseMoney) {
        return Integer.parseInt(purchaseMoney) % LOTTO_PRICE != 0;
    }
}
