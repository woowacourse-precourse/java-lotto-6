package lotto.model;
import java.util.List;
public class EunumRanking {
    public enum Ranking {
        FIRST(6, 2000000000L, "6개 일치 (2,000,000,000원) -"),
        SECOND(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
        THIRD(5, 1500000L, "5개 일치 (1,500,000원) -"),
        FOURTH(4, 50000L, "4개 일치 (50,000원) -"),
        FIFTH(3, 5000L, "3개 일치 (5,000원) -");
        private int cnt;
        private long price;
        private String sentence;

        private static final Ranking[] RANKIN_ARR = Ranking.values();

        Ranking(int cnt, long price, String sentence) {
            this.cnt = cnt;
            this.price = price;
            this.sentence = sentence;
        }

        public static void printSentence(Player player) {
            System.out.println();
            System.out.println("당첨통계");
            System.out.println("---");
            for (int i = RANKIN_ARR.length - 1; i > -1; i--) {
                System.out.println(RANKIN_ARR[i].sentence + " " + player.getMatchNum(i) + "개");
            }
            int price = player.getPrice();
            long total = player.getTotal();
            double divNum = (double) (total - price) / price;
            System.out.printf("총 수익률은 %.1f%%입니다.", (100 + divNum * 100));
        }

        //        __________________// 여기 코드 리팩토링 신경좀 쓰자 //_______________________________
        public static Ranking rankingTotal(int cnt, List<Integer> randomLotto, Player player) {
            if (cnt == 5) {
                return secondOrThird(randomLotto, player);
            }
            return otherRanking(cnt, player);
        }

        public static Ranking otherRanking(int cnt, Player player) {
            for (int i = 0; i < RANKIN_ARR.length; i++) {
                if (cnt == RANKIN_ARR[i].cnt) {
                    System.out.println(i);
                    player.updateTotal(RANKIN_ARR[i].price);
                    player.updateMatchCount(RANKIN_ARR[i].ordinal());
                    return RANKIN_ARR[i];
                }
            }
            return null;
        }


        //        __________________// 여기 코드 리팩토링 신경좀 쓰자 //_______________________________


        //        __________________// 여기 코드 리팩토링 신경좀 쓰자 //_______________________________
        public static Ranking secondOrThird(List<Integer> randomLotto, Player player) {
            if (randomLotto.contains(player.getBounusNumber())) {
                player.updateTotal(Ranking.SECOND.price);
                player.updateMatchCount(Ranking.SECOND.ordinal());
                return Ranking.SECOND;
            }
            player.updateTotal(Ranking.THIRD.price);
            player.updateMatchCount(Ranking.THIRD.ordinal());
            return Ranking.THIRD;
        }
        //        __________________// 여기 코드 리팩토링 신경좀 쓰자 //_______________________________
    }
}
