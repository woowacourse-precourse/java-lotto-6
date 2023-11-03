package lotto.domain;

public class LottoPurchase {
    private final int amount;

    public LottoPurchase(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public LottoPurchase(String amount) {
        int parsedAmount = stringToInt(amount);
        validateAmount(parsedAmount);
        this.amount = parsedAmount;
    }

    public int getAmount() {
        return amount;
    }

    private int stringToInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자형이 아닌 문자를 입력하였습니다.");
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수인 값만 입력해주세요.");
        }
    }
}
