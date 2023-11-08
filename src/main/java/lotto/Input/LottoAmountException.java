package lotto.Input;

public class LottoAmountException {

    private final int lottoPurchaseInput;

    public LottoAmountException(int lottoPurchaseInput) {
        validate(lottoPurchaseInput);
        this.lottoPurchaseInput = lottoPurchaseInput;
    }
    public void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매 가능합니다.");
        }
    }
}
