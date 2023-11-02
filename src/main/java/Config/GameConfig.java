package Config;

public class GameConfig {
    public final static int MIN_LOTTO = 1;
    public final static int MAX_LOTTO = 45;
    public final static int LOTTO_NUMBER = 6;
    public final static int MONEY_UNIT = 1_000;
    public final static String SEPARATOR = ",";
    public enum WINNING{
        FIRST(2_000_000_000, 1),
        SECOND(30_000_000, 2),
        THIRD(1_500_000, 3),
        FOURTH(50_000, 4),
        FIFTH(5_000, 5);

        private final int price;
        private final int rank;

        WINNING(int price, int rank){
            this.price = price;
            this.rank = rank;
        }

        public int getPrice(){
            return price;
        }

        public int getRank(){
            return rank;
        }
    }
}
