package lotto.config;

public class GameConfig {
    private GameConfig() {
    }

    public static final Integer START_INCLUSIVE = 1;
    public static final Integer END_INCLUSIVE = 45;
    public static final Integer NUMBER_OF_LOTTO_NUMBERS = 6;
    public static final Integer LOTTO_NUMBER_UNIT = 1_000;

    public static final Integer THREE_NUMBER_MATCH_PRIZE = 5_000;
    public static final Integer FOUR_NUMBER_MATCH_PRIZE = 50_000;
    public static final Integer FIVE_NUMBER_MATCH_PRIZE = 1_500_000;
    public static final Integer FIVE_NUMBER_MATCH_PRIZE_WITH_BONUS_PRIZE = 30_000_000;
    public static final Integer TOTAL_NUMBER_MATCH_PRIZE = 2_000_000_000;
}
