package lotto.model;

public class Rankings {
    public enum RankingData {
        FIRST("6개 일치","2,000,000,000원"),
        SECOND("5개 일치, 보너스 볼 일치","30,000,000원"),
        THIRD("5개 일치","1,500,000원"),
        FOURTH("4개 일치", "50,000원"),
        FIFTH("3개 일치", "5,000원");
        final String rankings;
        final String values;
        RankingData(String rankings, String values) {
            this.rankings = rankings;
            this.values = values;
        }

        public String getRankings() {
            return rankings;
        }

        public String getValues() {
            return values;
        }
        public static RankingData findRankings(String rankings) {
            return RankingData.valueOf(rankings);
        }
    }
}
