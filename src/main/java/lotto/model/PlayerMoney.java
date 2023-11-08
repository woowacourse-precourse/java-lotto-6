package lotto.model;

public class PlayerMoney {
    private final int money;

    public PlayerMoney(String money) {
        int playerMoney = isNumber(money);
        isThousand(playerMoney);

        this.money = playerMoney;
    }

    public int getNumOfLottoBuy() {
        return money / 1000;
    }

    public void isThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해 주세요.");
        }
    }

    private int isNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
