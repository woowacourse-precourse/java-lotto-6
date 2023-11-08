package lotto.Domain;

public enum LottoRate {
    FIRST_PLACE(6, "6개 일치 ", "(2,000,000,000원)", 2000000000),
    SECOND_PLACE(7, "5개 일치, 보너스 볼 일치, ", "(30,000,000원)", 30000000),
    THIRD_PLACE(5, "5개 일치 ", "(1,500,000원)", 1500000),
    FOURTH_PLACE(4, "4개 일치 ", "(50,000원)", 50000),
    FIFTH_PLACE(3, "3개 일치 ", "(5,000원)", 5000);
    private int rank;
    private String hit;
    private String prize;
    private int money;

    // Enum 생성자
    LottoRate(int rank, String hit, String prize, int money) {
        this.rank = rank;
        this.hit = hit;
        this.prize = prize;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public String getHit() {
        return hit;
    }

    public String getPrize() {
        return prize;
    }

    public int getMoney() {
        return money;
    }

    public static LottoRate getPlace(int rank) {
        for (LottoRate lottoRate : LottoRate.values()) {
            if (lottoRate.rank == rank) {
                return lottoRate;
            }
        }
        return null;
    }
}
