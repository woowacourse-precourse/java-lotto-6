package lotto.domain.model;

import lotto.domain.util.ErrorMessage;
import lotto.domain.util.InputValidator;

public class LottoSaleSystem {

    private static int purchaseMoney;
    private int purchaseCount;

    public void isValidMoney(String input) {
        try {
            InputValidator.isNull(input);
            InputValidator.isEmptyOrBlank(input);
            int purchaseMoney = Integer.parseInt(input);
            isValidMoneyUnit(purchaseMoney);
            this.purchaseMoney = purchaseMoney;
            this.purchaseCount = purchaseMoney / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_INPUT.getErrorMessage());
        }
    }

    // 구매 금액이 1000원 단위인지 검사
    private void isValidMoneyUnit(int purchaseMoney) {
        if (purchaseMoney <= 0 || purchaseMoney % 1000 > 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getErrorMessage());
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public static double calculateProfit() {
        int profitMoney = LottoWinnerSystem.calculateProfitMoney();
        return (double) profitMoney / purchaseMoney * 100;
    }
}
