package lotto.settings;

public enum WinningAmount {
//    - 1등: 6개 번호 일치 / 2,000,000,000원
//    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//    - 3등: 5개 번호 일치 / 1,500,000원
//    - 4등: 4개 번호 일치 / 50,000원
//    - 5등: 3개 번호 일치 / 5,000원
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int prize;

    WinningAmount(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
