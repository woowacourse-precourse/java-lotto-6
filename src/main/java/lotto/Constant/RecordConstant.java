package lotto.Constant;

public class RecordConstant {
    public static final int NUMBER_OF_RANKING = 5;
    public enum NameOfRanking
    {
            THREE_MATH(3, 0, "3개 일치 (5,000원) - ", 0),
        FOUR_MATCH(4, 0, "4개 일치 (50,000원) - ", 1),
        FIVE_MATCH(5, 0, "5개 일치 (1,500,000원) - ", 2),
        FIVE_BONUS_MATCH(5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 3),
        SIX_MATCH(6, 0, "6개 일치 (2,000,000,000원) - ", 4);

            private final int matchNumber;
            private final int bonusMatchNumber;
            private final String description;
            private final int index;

        NameOfRanking(int matchNumber, int bonusMatchNumber, String description, int index)
        {
            this.matchNumber= matchNumber;
            this.bonusMatchNumber = bonusMatchNumber;
            this.description = description;
            this.index = index;
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
    }
}
