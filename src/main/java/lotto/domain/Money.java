package lotto.domain;


public class Money {
    private int money;

    public Money(String inputMoney) {
        isInteger(inputMoney);
        money = Integer.parseInt(inputMoney);
        isThousands(money);
    }

    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void isThousands(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
