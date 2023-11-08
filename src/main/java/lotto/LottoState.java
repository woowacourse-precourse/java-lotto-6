package lotto;

import java.text.DecimalFormat;

public enum LottoState {

    FIFTH(3, 0, 5_000),
    FOURTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, 0, 2_000_000_000);

    final private int correctedNum;
    final private int bonus;
    final private int prize;
    private String condition;
    private int correctedLottoCnt = 0;

    LottoState(int correctedNum, int bonus, int prize) {
        this.correctedNum = correctedNum;
        this.bonus = bonus;
        this.prize = prize;
        String isCorrectedBonus = "";

        if (bonus == 1) {
            isCorrectedBonus = ", 보너스 볼 일치";
        }

        String prizeAmount = String.valueOf(prize).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        this.condition = String.format("%d개 일치%s (%s원)", this.correctedNum, isCorrectedBonus, prizeAmount);
    }

    public void countNumberOfWinningNumbers() {
        correctedLottoCnt++;
    }

    public int calculateWinningAmount() {
        return prize * correctedLottoCnt;
    }

    @Override
    public String toString() {
        return String.format("%s - %d개", condition, correctedLottoCnt);
    }
}
