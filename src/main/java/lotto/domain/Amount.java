package lotto.domain;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(String amount) {
        if (isInvalidType(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 숫자가 아닙니다.");
        }
        if (isInvalidUnit(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private boolean isInvalidUnit(String amount) {
        int amount_temp = Integer.parseInt(amount);
        if (amount_temp > 0 && amount_temp % 1000 == 0) {
            return false;
        }
        return true;
    }

    private boolean isInvalidType(String amount) {
        try {
            Integer.parseInt(amount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public int calculateLottoPurchaseSize() {
        return amount / 1000;
    }

    public double calculateProfitRate(Long reward) {
        return (reward / (float) amount) * 100;
    }
}