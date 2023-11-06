package lotto.Model;

import java.util.List;

enum LottoPrize {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    FAIL(0,0,"");

    private final int matchingNumbers;
    private final int prize;
    private final String description;

    LottoPrize(int matchingNumbers, int prize, String description) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }
    public String getDescription() {
        return description;
    }
    public static LottoPrize checkLottoResult(int count, boolean hasBonus) {
        if (count == 3) {
            return LottoPrize.FIFTH; // 3개 일치
        } else if (count == 4) {
            return LottoPrize.FOURTH; // 4개 일치
        } else if (count == 5) {
            if (hasBonus) {
                return LottoPrize.SECOND; // 5개 일치, 보너스 볼 일치
            }
            return LottoPrize.THIRD; // 5개 일치
        } else if (count == 6) {
            return LottoPrize.FIRST; // 6개 일치
        }
        return LottoPrize.FAIL; // 미당첨
    }
    public  void printMessage(int count){
        if (this != FAIL){
            System.out.println(description);
        }
    }
}
