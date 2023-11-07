package lotto.collaboration.enums;

public enum LottoStoreMessage {

    EXCEPTION_INDIVISIBLE("원 단위로 입력해 주세요"),
    EXCEPTION_PRE_OUT_OF_RANGE("로또 구매 금액은 "),
    EXCEPTION_MIDDLE_OUT_OF_RANGE("원에서 "),
    EXCEPTION_POST_OUT_OF_RANGE("원까지만 가능합니다."),
    ;

    private final String message;

    LottoStoreMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public static String makeMessageForIndivisible(int minPurchaseAmount) {
        return minPurchaseAmount + EXCEPTION_INDIVISIBLE.get();
    }

    public static String makeMessageForOutOfRange(int minPurchaseAmount, int maxPurchaseAmount) {
        return EXCEPTION_PRE_OUT_OF_RANGE.get()
                + minPurchaseAmount
                + EXCEPTION_MIDDLE_OUT_OF_RANGE.get()
                + maxPurchaseAmount
                + EXCEPTION_POST_OUT_OF_RANGE.get();
    }

}
