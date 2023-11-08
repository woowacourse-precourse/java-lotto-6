package lotto.model;

public class WinningStatics {
    private static final int MATCH_THREE_REWARD = 5_000;
    private static final int MATCH_FOUR_REWARD = 50_000;
    private static final int MATCH_FIVE_REWARD = 1_500_000;
    private static final int MATCH_FIVE_AND_BONUS_REWARD = 30_000_000;
    private static final int MATCH_SIX_REWARD = 2_000_000_000;

    private int matchThree;
    private int matchFour;
    private int matchFive;
    private int matchFiveAndBonus;
    private int matchSix;

    public WinningStatics() {
        this.matchThree = 0;
        this.matchFour = 0;
        this.matchFive = 0;
        this.matchFiveAndBonus = 0;
        this.matchSix = 0;
    }

    public WinningStatics(int matchThree, int matchFour, int matchFive,
                          int matchFiveAndBonus, int matchSix) {
        this.matchThree = matchThree;
        this.matchFour = matchFour;
        this.matchFive = matchFive;
        this.matchFiveAndBonus = matchFiveAndBonus;
        this.matchSix = matchSix;
    }

    public void applyLottoResult(int matchCount, boolean isMatchBonus) {
        switch (matchCount) {
            case 0, 1, 2 -> {
            }
            case 3 -> matchThree++;
            case 4 -> matchFour++;
            case 5 -> {
                if (isMatchBonus) {
                    matchFiveAndBonus++;
                } else {
                    matchFive++;
                }
            }
            case 6 -> this.matchSix++;
            default -> throw new IllegalArgumentException("[Error] Match Count Invalid");
        }
    }

    public float getRateOfReturn(int purchasePrice) {
        int totalReward = getTotalReward();
        return (float) totalReward/purchasePrice * 100;
    }

    private int getTotalReward() {
        return matchThree * MATCH_THREE_REWARD +
                matchFour * MATCH_FOUR_REWARD +
                matchFive * MATCH_FIVE_REWARD +
                matchFiveAndBonus * MATCH_FIVE_AND_BONUS_REWARD +
                matchSix * MATCH_SIX_REWARD;
    }



    @Override
    public String toString() {
        String MATCH_THREE_TO_STRING = "3개 일치 (5,000원) - %d개\n";
        String MATCH_FOUR_TO_STRING = "4개 일치 (50,000원) - %d개\n";
        String MATCH_FIVE_TO_STRING = "5개 일치 (1,500,000원) - %d개\n";
        String MATCH_FIVE_AND_BONUS_TO_STRING = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
        String MATCH_SIX_TO_STRING = "6개 일치 (2,000,000,000원) - %d개\n";

        return String.format(MATCH_THREE_TO_STRING + MATCH_FOUR_TO_STRING +
                        MATCH_FIVE_TO_STRING + MATCH_FIVE_AND_BONUS_TO_STRING + MATCH_SIX_TO_STRING,
                matchThree, matchFour, matchFive, matchFiveAndBonus, matchSix);
    }
}
