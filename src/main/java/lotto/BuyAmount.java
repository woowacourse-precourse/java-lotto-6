package lotto;

public class BuyAmount {
    private final static Integer UNIT = 1000;
    private final Integer buyAmount;

    public BuyAmount(String buyAmount) {
        validateInteger(buyAmount);
        this.buyAmount = Integer.parseInt(buyAmount);
        validateUnit(this.buyAmount);
    }

    private void validateInteger(String buyAmount) {
        try {
            Integer.parseInt(buyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력하신 값은 정수로 변환할 수 없습니다.");
        }
    }

    private void validateUnit(Integer buyAmount) {
        if (buyAmount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1,000원으로 나누어 떨어지지 않습니다");
        }
    }

    public Integer getBuyAmount() {
        return this.buyAmount;
    }

    public Integer getBuyCount() {
        return this.buyAmount / 1000;
    }
}
