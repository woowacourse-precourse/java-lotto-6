package lotto;

public class LottoAmount {
    private final int amount;

    public LottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public int LottoCount() {
        return amount / 1000;
    }


    private void validateAmount(int amount) {
        validateDivisible(amount);
    }

    private static int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            throw new IllegalArgumentException();
        }
    }


    private void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            System.out.println("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.");
            throw new IllegalArgumentException();
        }
    }
}
