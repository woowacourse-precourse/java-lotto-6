package lotto.constants;

public class ConstNums {
    public static final int BOUND_MAX = 45;
    public static final int BOUND_MIN = 1;
    public static final int LOTTERY_LENGTH = 6;

    public enum WinCondition {
        FIRST(LOTTERY_LENGTH),
        SECOND(LOTTERY_LENGTH - 1),
        THIRD(LOTTERY_LENGTH - 1),
        FOURTH(LOTTERY_LENGTH - 2),
        FIFTH(LOTTERY_LENGTH - 3);

        int condition;

        WinCondition(int condition) {
            this.condition = condition;
        }

        public int getCondition() {
            return condition;
        }
    }

}
