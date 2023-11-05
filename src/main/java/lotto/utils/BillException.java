package lotto.utils;

public class BillException {
    public static boolean isBillValid(int Bill) {
        if (Bill % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야합니다");
        }
        return true;
    }
}
