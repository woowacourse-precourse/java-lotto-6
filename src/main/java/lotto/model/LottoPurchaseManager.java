package lotto.model;

import lotto.exception.Validation;

import java.util.List;

public class LottoPurchaseManager {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private final int purchaseAmount;
    private int lottoTicketCount;
    private List<LottoResult> winningTicket;

    public LottoPurchaseManager(int purchaseAmount,
                                int lottoTicketCount,
                                List<LottoResult> winningTicket) {
        Validation.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoTicketCount = lottoTicketCount;
        this.winningTicket = winningTicket;
    }

    public static int getLottoTicketPrice() {
        return LOTTO_TICKET_PRICE;
    }

    public int calculateLottoTicketCount() {
        return this.purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public double calculateProfitRate() {
        double profitRate = ((double) calculateTotalPrize() / purchaseAmount) * 100;

        return roundToSecondDecimalPlace(profitRate);
    }

    private double roundToSecondDecimalPlace(double value) {
        return Math.round(value * 10) / 10.0;
    }

    private int calculateTotalPrize() {
        return winningTicket.stream()
                .mapToInt(LottoResult::getPrizeMoney)
                .sum();
    }
}
