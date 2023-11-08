package lotto.Constant;

public class RecordConstant {
    public static final int NUMBER_OF_RANKING = 5;
    public enum NameOfRanking
    {
            THREE_MATCH(3, 0, "3개 일치 (5,000원) - ", 0, 5000),
        FOUR_MATCH(4, 0, "4개 일치 (50,000원) - ", 1, 50000),
        FIVE_MATCH(5, 0, "5개 일치 (1,500,000원) - ", 2, 1500000),
        FIVE_BONUS_MATCH(5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 3, 30000000),
        SIX_MATCH(6, 0, "6개 일치 (2,000,000,000원) - ", 4, 2000000000);

            private final int matchNumber;
            private final int bonusMatchNumber;
            private final String description;
            private final int index;
            private final int reward;

        NameOfRanking(int matchNumber, int bonusMatchNumber, String description, int index, int reward)
        {
            this.matchNumber= matchNumber;
            this.bonusMatchNumber = bonusMatchNumber;
            this.description = description;
            this.index = index;
            this.reward = reward;
        }

        public static NameOfRanking findByIndex(int index) {
            for (NameOfRanking value : NameOfRanking.values()) {
                if (value.getIndex() == index) {
                    return value;
                }
            }
            throw new IllegalArgumentException("No enum constant with index: " + index);
        }

        public int getMatchNumber()
        {
            return this.matchNumber;
        }

        public int getBonusMatchNumber()
        {
            return bonusMatchNumber;
        }

        public String getDescription()
        {
            return description;
        }

        public int getIndex()
        {
            return index;
        }

        public int getReward() { return reward; }
    }
}
