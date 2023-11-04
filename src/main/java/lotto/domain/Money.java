package lotto.domain;

public class Money {
    private final int money;

    public Money(String input) {
        hasOnlyNumbers(input);
        this.money = Integer.parseInt(input);
        isAtLeastPrice(money);
        isDividedByPrice(money);
    }

    public int getMoney() {
        return money;
    }

    private void hasOnlyNumbers(String input) {
        if (!input.matches("^[0-9]*$")) { // "^[0-9]*$" : 숫자를 의미하는 정규표현식
            throw new IllegalArgumentException();
        }
    }

    private void isAtLeastPrice(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private void isDividedByPrice(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
