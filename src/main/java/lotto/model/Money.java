package lotto.model;

public class Money {

    private static final String NUMBER_ERROR_MESSAGE = "구입 금액은 숫자만 입력해주세요.";
    private static final String RANGE_ERROR_MESSAGE = "구입 금액은 1,000 원 이상이여야 합니다.";
    private static final String UNIT_ERROR_MESSAGE = "구입 금액은 1,000 원 단위로 입력해주셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public int countLottos() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return this.money;
    }

    private void validateMoney(String money) {
        if (!money.matches("\\d+")) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        if (Integer.parseInt(money) == 0) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        if ((Integer.parseInt(money) % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }
}
