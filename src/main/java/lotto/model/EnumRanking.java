package lotto.model;

import lotto.view.OutputView;

import java.util.List;

public class EnumRanking {
    public enum Ranking {
        FIRST(6, 2000000000L, "6개 일치 (2,000,000,000원) -"),
        SECOND(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
        THIRD(5, 1500000L, "5개 일치 (1,500,000원) -"),
        FOURTH(4, 50000L, "4개 일치 (50,000원) -"),
        FIFTH(3, 5000L, "3개 일치 (5,000원) -"),
        LAST(0, 0, null);
        private final int cnt;
        private final long price;
        private final String sentence;

        private static final Ranking[] RANKING_ARR = Ranking.values();

        Ranking(int cnt, long price, String sentence) {
            this.cnt = cnt;
            this.price = price;
            this.sentence = sentence;
        }

        public static void printSentence(Player player) {
            OutputView.printWinningResultPreFace();
            for (int i = RANKING_ARR.length - 2; i > -1; i--) {
                OutputView.printWinningResult(RANKING_ARR[i].sentence, player.getMatchNum(i));
            }
            OutputView.printWinningTotal(player);
        }


        public static Ranking otherRanking(int cnt) {
            for (int i = 0; i < RANKING_ARR.length; i++) {
                if (cnt == RANKING_ARR[i].cnt) {
                    return RANKING_ARR[i];
                }
            }
            return Ranking.LAST;
        }


        public static Ranking matchPoint(int cnt, List<Integer> randomLotto, Player player) {
            if (cnt == 5) {
                return secondOrThird(randomLotto, player);
            }
            return otherRanking(cnt);
        }

        public static Ranking secondOrThird(List<Integer> randomLotto, Player player) {
            if (randomLotto.contains(player.getBonusNumber())) {
                return Ranking.SECOND;
            }

            return Ranking.THIRD;
        }

        public static Long getPrice(Ranking ranking) {
            return ranking.price;
        }
    }

}

