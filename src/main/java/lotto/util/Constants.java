package lotto.util;

public class Constants {
    public static final String NUMBER_REGEXP = "^[\\d]*$";
    public static final String BLANK = " ";
    public static final String SPLIT = ",";
    public static final int INITIAL_VALUE = 0;
    public static final int LOTTO_MAX_SIZE = 6;
    public static final int REMAINDER = 0;
    public static final int DIVISION_VALUE = 1000;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final double PERCENTAGE = 100.0;

    public enum LottoResult {
        TREE(3,5000),
        FOUR(4,50000),
        FIVE(5,1500000),
        FIVE_AND_BONUS(7,30000000),
        SIX(6,2000000000);

        private final int count;
        private final int money;

        LottoResult(int count, int money){
            this.count = count;
            this.money = money;
        }
        public int getCount(){
            return this.count;
        }
        public int getMoney() {
            return this.money;
        }

    }
    public enum Format {
        LOTTO("로또"),
        BONUS_NUMBER("보너스 번호");

        private final String type;

        Format(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }
}
