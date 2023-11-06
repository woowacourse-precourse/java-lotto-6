package lotto.model;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_LEAST_PRICE_ERROR_MESSAGE = "[ERROR] 최소 1000원 이상의 돈을 입력해주세요.";
    private final int purchaseAmount;

    public PurchaseAmount(int inputMoney) {
        validate(inputMoney);
        this.purchaseAmount = inputMoney;
    }

    private void validate(int inputMoney) {
        checkLeastLottoPrice(inputMoney);
    }

    private void checkLeastLottoPrice(int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException(INPUT_LEAST_PRICE_ERROR_MESSAGE);
        }
    }

    public int getMaxLottoCountForBudget() {
        return this.purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}
