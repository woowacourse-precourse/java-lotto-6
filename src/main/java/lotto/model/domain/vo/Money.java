package lotto.model.domain.vo;

import java.util.Objects;

public class Money {
    private int won;

    public Money(String input) {
        int money = parseInt(input);
        this.won = money;
    }

    private int parseInt(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
        return money;
    }

    public int getMoney() {
        return this.won;
    }

    public void validateDivideBy1000() {
        if (won % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위의 금액이 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return won == money.won;
    }

    @Override
    public int hashCode() {
        return Objects.hash(won);
    }
}
