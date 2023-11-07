package lotto.constant;

public enum PrizeConstant {

    FIRST(7,"6개 일치 (2,000,000,000원) - ", 2000000000),
    SECOND(6, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    THIRD(5, "5개 일치 (1,500,000원) - ", 1500000),
    FOURTH(4, "4개 일치 (50,000원) - ",50000),
    FIFTH(3, "3개 일치 (5,000원) - ",5000);
    private final int score;
    private final String message;
    private final int reward;

    PrizeConstant(int score, String message, int reward) {
        this.score = score;
        this.message = message;
        this.reward = reward;
    }

    public static String getMessageByScore(int score) {
        for (PrizeConstant prize : PrizeConstant.values()) {
            if (prize.score == score) {
                return prize.message;
            }
        }

        return "일치하는 메시지가 없습니다.";
    }

    public static int getRewardByScore(int score) {
        for (PrizeConstant prize : PrizeConstant.values()) {
            if (prize.score == score) {
                return prize.reward;
            }
        }

        return 0;
    }

}
