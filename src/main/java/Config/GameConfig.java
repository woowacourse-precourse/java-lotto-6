package Config;

import java.util.Arrays;
import java.util.Comparator;

public class GameConfig {
    public final static int MIN_LOTTO = 1;
    public final static int MAX_LOTTO = 45;
    public final static int LOTTO_NUMBER = 6;
    public final static String SEPARATOR = ",";

    public enum WINNING{
        FIRST(2_000_000_000, 1, 6, "6개 일치"),
        SECOND(30_000_000, 2, 6, "5개 일치, 보너스 볼 일치"),
        THIRD(1_500_000, 3, 5, "5개 일치"),
        FOURTH(50_000, 4, 4, "4개 일치"),
        FIFTH(5_000, 5, 3, "3개 일치");

        private final int price;
        private final int rank;
        private final int match;
        private final String matchAmount;

        WINNING(int price, int rank, int match, String matchAmount){
            this.price = price;
            this.rank = rank;
            this.match = match;
            this.matchAmount = matchAmount;
        }

        public int getPrice(){
            return price;
        }

        public int getRank(){
            return rank;
        }

        public int getMatch(){
            return match;
        }

        public String getMatchAmount(){
            return matchAmount;
        }

        public static WINNING valueOfRank(int rank){
            return Arrays.stream(values())
                    .filter(value -> value.rank == rank)
                    .findAny()
                    .orElse(null);
        }

        public static WINNING valueOfMatch(int match) {
            return Arrays.stream(values())
                    .filter(value -> value.match == match)
                    .findFirst()
                    .orElse(null);
        }

        public static WINNING valueOfMinMatch(){
            return Arrays.stream(values())
                    .min(Comparator.comparing(value -> value.match))
                    .orElse(null);
        }

        public static WINNING valueOfMaxMatch(){
            return Arrays.stream(values())
                    .max(Comparator.comparing(value -> value.match))
                    .orElse(null);
        }
    }
}
