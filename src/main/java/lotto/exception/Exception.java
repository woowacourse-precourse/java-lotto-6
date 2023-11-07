package lotto.exception;

public class Exception {
    public int checkInt(String totalAmount) {
        int amount = 0;
        try {
            amount = Integer.parseInt(totalAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 1000 단위 숫자로 입력해주세요.");
            throw new IllegalArgumentException(e);
        } finally {
            return amount;
        }
    }
}
