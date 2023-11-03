package lotto;

public class Money {
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        if (isInvalidType(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (isInvalidUnit(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private boolean isInvalidType(String target) {
        try {
            Integer.parseInt(target);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isInvalidUnit(String target) {
        int money = Integer.parseInt(target);
        if(money > 0 && money % 1000 == 0){
            return false;
        }
        return true;
    }
}
