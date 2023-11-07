package lotto.domain;

public enum Winner {
    FIRST_PLACE("6개 일치 (2,000,000,000원)", 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD_PLACE("5개 일치 (1,500,000원)", 1500000),
    FOURTH_PLACE("4개 일치 (50,000원)", 50000),
    FIFTH_PLACE("3개 일치 (5,000원)", 5000);

    private String message;
    private int prize;

    Winner(String message, int prize) {
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}