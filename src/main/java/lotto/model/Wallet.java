package lotto.model;

import java.util.Map;

public class Wallet {
    private static final int MAXIMUM_PURCHASE_AMOUNT =  1000000000;
    private static final int LOTTO_PRICE = 1000;

    private final int initialAmount;
    private int money;

    public Wallet(String money) {
        validateMoney(money);
        initialAmount = convertStringToInt(money);
        this.money = initialAmount;
    }

    private void validateMoney(String money) {
        validateNotNullMoney(money);
        validateNonNumericMoney(money);
        validateNotDivisionMoney(money);
        validateOutOfRangeMoney(money);
    }

    public boolean canBuyLotto() {
        return money - LOTTO_PRICE >= 0;
    }

    public void buyLotto() {
        money -= LOTTO_PRICE;
    }

    private void validateNonNumericMoney(String money) {
        if (!money.matches("^[0-9]*")) {
            throw new IllegalArgumentException("[Error] 구입 금액에 숫자가 아닌 값이 들어왔습니다.");
        }
    }

    private void validateNotNullMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                    + MAXIMUM_PURCHASE_AMOUNT + "원.");
        }
    }

    private void validateOutOfRangeMoney(String money) {
        int convertMoney = convertStringToInt(money);

        if (convertMoney > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                    + MAXIMUM_PURCHASE_AMOUNT + "원.");
        }
    }

    private void validateNotDivisionMoney(String money) {
        int convertMoney = convertStringToInt(money);

        if (convertMoney == 0 || convertMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                    + MAXIMUM_PURCHASE_AMOUNT + "원.");
        }
    }

    private int convertStringToInt(String money) {
        int convertMoney;

        try {
            convertMoney = Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                    + MAXIMUM_PURCHASE_AMOUNT + "원.");
        }
        return convertMoney;
    }

    public double calculateProfitRate(long profit) {
        return Math.round(((double)initialAmount / (double)profit) * 10.0) / 10.0;
    }
}
