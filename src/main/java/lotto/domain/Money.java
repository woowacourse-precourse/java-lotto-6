package lotto.domain;

public record Money(long value) {

    public Money {
        if (value < 0) {
            throw new IllegalArgumentException("돈은 0보다 작을 수 없습니다.");
        }
    }

    public double calculateProfit(Money profit) {
        var temp = profit.value * 1.0 / value * 100;
        return (double) Math.round(temp * 100) / 100;
    }
}
