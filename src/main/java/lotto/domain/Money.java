package lotto.domain;

import lotto.constants.LottoStatus;

public class Money {
    private final int money;
    private final int Tickets;

    public Money(String input) {
        hasOnlyNumbers(input);
        this.money = Integer.parseInt(input);
        isMoreThanPrice(money);
        isDividedByPrice(money);
        this.Tickets = money / LottoStatus.PRICE;
    }

    public int getMoney() {
        return money;
    }

    public int getTickets() {
        return Tickets;
    }

    private void hasOnlyNumbers(String input) {
        if (!input.matches("^[0-9]*$")) { // "^[0-9]*$" : 숫자를 의미하는 정규표현식
            throw new IllegalArgumentException();
        }
    }

    private void isMoreThanPrice(int money) {
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
