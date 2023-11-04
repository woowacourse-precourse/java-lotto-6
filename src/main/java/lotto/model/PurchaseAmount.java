package lotto.model;

public class PurchaseAmount {
    private static final String NON_NUMERIC_INPUT_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(String inputMoney) {
        try {
            int money = Integer.parseInt(inputMoney);
            this.purchaseAmount = money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }

    public int getMaxLottoCountForBudget() {
        return this.purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}
