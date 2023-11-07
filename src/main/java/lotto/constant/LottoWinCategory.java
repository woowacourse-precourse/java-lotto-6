package lotto.constant;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public enum LottoWinCategory {
    FIRST_PRIZE(6, false, 2000000000),

    SECOND_PRIZE(5, true, 30000000),

    THIRD_PRIZE(5, false, 1500000),

    FOURTH_PRIZE(4, false, 50000),

    FIFTH_PRIZE(3, false, 5000),

    NO_PRIZE(0, false, 0)
    ;

    private final int count;
    private final boolean bonus;
    private final int prize;

    private static final String MATCH_COUNT = "개 일치";
    private static final String BONUS_MATCH_COUNT = ", 보너스 볼 일치";
    private static final DecimalFormat WINNING_PRIZE_FORMAT = new DecimalFormat("#,###");

    LottoWinCategory(int count, boolean bonus, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static List<LottoWinCategory> getWinningValues() {
        List<LottoWinCategory> values = new java.util.ArrayList<>(List.of(LottoWinCategory.values()));
        values.remove(NO_PRIZE);
        values.sort(Comparator.comparingInt(o -> o.prize));
        return values;
    }

    public static LottoWinCategory getWinningCategoryByCountAndBonus(int count, boolean bonus, List<LottoWinCategory> lottoWinningCategories) {
        if (count == SECOND_PRIZE.count + 1 && bonus) {
            return SECOND_PRIZE;
        }
        return lottoWinningCategories.stream()
                .filter(category -> category.isMatched(count))
                .findFirst()
                .orElse(LottoWinCategory.NO_PRIZE);
    }


    public boolean isMatched(int count) {
        return this.count == count;
    }

    public String convertPrizeToString() {
        return WINNING_PRIZE_FORMAT.format((double) prize);
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(count).append(MATCH_COUNT);
        if (bonus)
            sb.append(BONUS_MATCH_COUNT);
        sb.append(" (").append(convertPrizeToString()).append("원)");
        return sb.toString();
    }
}
