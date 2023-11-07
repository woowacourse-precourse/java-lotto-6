package lotto.domain;

import lotto.util.Constants;
import lotto.util.Validator;

public class TicketAmount {
    private static final int PERCENT = 100;
    private final int amount;

    public TicketAmount(String money) {
        int purchaseAmount = Integer.parseInt(money);
        validateMoney(purchaseAmount);
        this.amount = purchaseAmount;
    }

    public int calculateTicketAmount() {
        return amount / Constants.LOTTO_MIN_AMOUNT;
    }

    public double calculateRateOfReturn(Result result) {
        double totalPrize  = result.getLottoResult().entrySet().stream()
                .filter(entry -> LottoRanking.NO_MATCH != entry.getKey())
                .map(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .mapToDouble(Integer::doubleValue).sum();
        return totalPrize / amount * PERCENT;
    }

    private static void validateMoney(int money) {
        Validator.validateInputIsNatural(money);
        Validator.validateNonDivisibility(money);
    }
}
