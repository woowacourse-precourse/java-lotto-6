package lotto.v3.controller;

import lotto.v3.view.LottoPurchaseView;

import static lotto.v3.util.LottoConstants.LOTTO_PRICE;

public class LottoPurchaseController {

    private final LottoPurchaseView lottoPurchaseView;

    public LottoPurchaseController(LottoPurchaseView lottoPurchaseView) {
        this.lottoPurchaseView = lottoPurchaseView;
    }

    public int startPurchaseProcess() {
        while (true){
            try{
                int purchaseAmount = lottoPurchaseView.requestPurchaseAmount();
                validatePurchaseAmount(purchaseAmount);
                int numberOfLottoTickets = calculateLottoTicketsPurchasable(purchaseAmount);
                lottoPurchaseView.displayNumberOfLottoTicketsPurchased(numberOfLottoTickets);
                return numberOfLottoTickets;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다.");
        }
    }

    private int calculateLottoTicketsPurchasable(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }

}
