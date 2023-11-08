package lotto.utils;

public class BillException {
    static final String BILL_MUST_DIVIDED = "[ERROR] 구매 금액은 1000원 단위여야합니다.";
    static final String BILL_ABOVE_ZERO = "[ERROR] 구매 금액은 1000원 이상이어야합니다.";

    public static void isBillValid(int Bill) {
        isBillAboveZero(Bill);
        isBillDividable(Bill);
    }
    public static void isBillDividable(int Bill) {
        if (Bill % 1000 != 0) {
            throw new IllegalArgumentException(BILL_MUST_DIVIDED);
        }
    }
    public static void isBillAboveZero(int Bill) {
        if (Bill <= 0) {
            throw new IllegalArgumentException(BILL_ABOVE_ZERO);
        }
    }
}
