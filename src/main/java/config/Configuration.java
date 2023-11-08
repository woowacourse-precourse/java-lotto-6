package config;

public class Configuration {
    // 로또 번호에 관한 구성
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;

    // 로또 당첨 금액에 관한 구성
    public static final int FIRST_WINNING_AMOUNT = 2000000000;
    public static final int SECOND_WINNING_AMOUNT = 30000000;
    public static final int THIRD_WINNING_AMOUNT = 1500000;
    public static final int FOURTH_WINNING_AMOUNT = 50000;
    public static final int FIFTH_WINNING_AMOUNT = 5000;

    public static final int LOTTO_PRICE = 1000;

    private Configuration() {
    }
}
