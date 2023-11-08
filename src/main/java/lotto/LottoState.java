package lotto;

public enum LottoState {

    FIFTH(3, 0, 5_000),
    FOURTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND (5,1, 30_000_000),
    FIRST_GRADE(6, 0, 2_000_000_000);

    private int correctedNum;
    private int bonus;
    private int prize;
    private String condition;
    private int coreectedLottoCnt=0;

    LottoState (int correctedNum, int bonus, int prize) {
        this.correctedNum = correctedNum;
        this.bonus = bonus;
        this.prize = prize;
        String isCorrectedBonus = "";
        if (bonus == 1) {
            isCorrectedBonus = ", 보너스 볼 일치";
        }

        this.condition = String.format("/d개 일치/s (/s원)", this.correctedNum, isCorrectedBonus, prize);
    }

    @Override
    public String toString() {
        return condition;
    }
}
