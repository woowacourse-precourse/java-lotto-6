package lotto.model;

import java.util.Arrays;

public class Rankings {
    public enum RankingData {

        FIRST("6개 일치 (2,000,000,000원) - ",6, 2000000000),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",0, 30000000),
        THIRD("5개 일치 (1,500,000원) - ", 5, 1500000),
        FOURTH("4개 일치 (50,000원) - ", 4, 50000),
        FIFTH("3개 일치 (5,000원) - ", 3, 5000);
        final String rankings;
        final int values;
        final int prizes;
        RankingData(String rankings, int values, int prizes) {
            this.rankings = rankings;
            this.values = values;
            this.prizes = prizes;
        }

        public String getRankings() {
            return rankings;
        }

        public int getValues() {
            return values;
        }
        public int getPrizes() {
            return prizes;
        }
        public static RankingData returnRank(int rankingValues) {

            if(rankingValues == FIRST.values)
                return FIRST;
            if(rankingValues == SECOND.values)
                return SECOND;
            if(rankingValues == THIRD.values)
                return THIRD;
            if(rankingValues == FOURTH.values)
                return FOURTH;
            if(rankingValues == FIFTH.values)
                return FIFTH;
            return null;
        }
    }
}
