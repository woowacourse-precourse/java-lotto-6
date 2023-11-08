package lotto.domain;

public enum Grade {
    FIRST(2_000_000_000), SECOND(30_000_000), THIRD(1_500_000), FOURTH(50_000), FIFTH(5_000), NONE(0);

    Integer prize;

    Grade(Integer prize) {
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }
}
