package lotto;

final class LottoInit {
    public int purchaseAmount;
    public int numberOfLotto;

    public LottoInit(int purchaseAmount, int numberOfLotto) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.numberOfLotto = numberOfLotto;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_PURCHASE_INPUT.getMessage());
        }
    }
}
