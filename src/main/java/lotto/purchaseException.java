package lotto;

public class purchaseException {
    public static void isNumeric(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isEmpty())
            throw new IllegalArgumentException("빈 금액은 입력할 수 없습니다.");
        for (char c : purchaseAmount.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("구입 금액은 숫자여야 합니다");
            }
        }
    }
    public static void isDividedByThousand(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000단위로 입력해주세요");
        }
    }
}
