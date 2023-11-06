package lotto.domain;

public record Money(int value) {

    public Money {
        if (value < 0) {
            throw new IllegalArgumentException("돈은 0보다 작을 수 없습니다.");
        }
    }

}
