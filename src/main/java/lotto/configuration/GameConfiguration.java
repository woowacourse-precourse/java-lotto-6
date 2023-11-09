package lotto.configuration;

public final class GameConfiguration {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final long MIN_PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_PRICE_PER_UNIT = 1000;
    public static final int REQUIRED_BONUS_NUMBER_RANK = 2;
    public static final int STANDARD_PARTS_PER = 100;
    public static final String INPUT_SEPARATOR = ",";
    public static final String DECIMAL_REGEX = "\\B(?=(\\d{3})+(?!\\d))";
    public static final String DECIMAL_SEPARATOR = ",";
    private GameConfiguration() {}
}
