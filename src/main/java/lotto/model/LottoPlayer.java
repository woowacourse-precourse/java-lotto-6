package lotto.model;

import static lotto.util.Constant.*;

import lotto.util.validate.PurchaseMoneyValidator;

public class LottoPlayer {

    private final int purchaseMoney;
    private final int numberOfLottoTickets;

    public LottoPlayer(String purchaseMoney) {
        PurchaseMoneyValidator.validate(purchaseMoney);

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
}
