package lotto.domain.player.playermoney;

public class HoldingMoney{
    final static String MONEY_UNIT_WRONG_MESSAGE = "구입금액의 단위는 1,000원 입니다.";
    final static int MONEY_UNIT = 1000;
    private final int holdingMoney;

    HoldingMoney(int holdingMoney) {
        validateMoneyUnit(holdingMoney);
        this.holdingMoney = holdingMoney;
    }

    static void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_WRONG_MESSAGE);
        }
    }

    HoldingMoney consumeHoldingMoney(int consumeMoney) {
        return new HoldingMoney(holdingMoney - consumeMoney);
    }

    int getHoldingMoney() {
        return holdingMoney;
    }
}
