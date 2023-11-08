package lotto.domain;

import lotto.util.LottoGameUtil;
import lotto.util.OutputUtil;

import java.util.EnumMap;
import java.util.List;

public class WinningStatistic {
    private static final String RATE_OF_RETURN_FORMAT = "%.1f";
    private static final int HUNDRED = 100;
    private static EnumMap<LottoScore, Integer> map;

    private WinningStatistic(EnumMap<LottoScore, Integer> map) {
        this.map = map;
    }

    private static void reset(EnumMap<LottoScore, Integer> tmp) {
        tmp.put(LottoScore.FIFTH_PLACE, LottoGameUtil.ZERO);
        tmp.put(LottoScore.FOURTH_PLACE, LottoGameUtil.ZERO);
        tmp.put(LottoScore.THIRD_PLACE, LottoGameUtil.ZERO);
        tmp.put(LottoScore.SECOND_PLACE, LottoGameUtil.ZERO);
        tmp.put(LottoScore.FIRST_PLACE, LottoGameUtil.ZERO);
        tmp.put(LottoScore.NOTHING, LottoGameUtil.ZERO);
    }
    private static void checkWinningStatistic(EnumMap<LottoScore, Integer> tmp, LottoScore lottoScore) {
        tmp.replace(lottoScore, tmp.get(lottoScore) + 1);
    }

    public static WinningStatistic from(List<LottoScore> winningStatistics) {
        EnumMap<LottoScore, Integer> tmp = new EnumMap<>(LottoScore.class);
        reset(tmp);
        winningStatistics.forEach(winningStatistic -> checkWinningStatistic(tmp, winningStatistic));
        return new WinningStatistic(tmp);
    }

    private String getRateOfReturn(int purchaseAmount) {
        int totalAmount = map.keySet()
                .stream()
                .mapToInt(key -> getScoreAmount(key))
                .sum();
        return String.format(RATE_OF_RETURN_FORMAT, (double) totalAmount / (double) purchaseAmount * HUNDRED);
    }

    private int getScoreAmount(LottoScore key) {
        return key.getMoney() * map.get(key);
    }
    public void view(int purchaseAmount) {
        OutputUtil.println(LottoScore.FIFTH_PLACE.getName() + LottoScore.FIFTH_PLACE.getValue() + LottoGameUtil.CONTOUR_WITH_BLANK + map.get(LottoScore.FIFTH_PLACE) + "개");
        OutputUtil.println(LottoScore.FOURTH_PLACE.getName() + LottoScore.FOURTH_PLACE.getValue() + LottoGameUtil.CONTOUR_WITH_BLANK + map.get(LottoScore.FOURTH_PLACE) + "개");
        OutputUtil.println(LottoScore.THIRD_PLACE.getName() + LottoScore.THIRD_PLACE.getValue() + LottoGameUtil.CONTOUR_WITH_BLANK + map.get(LottoScore.THIRD_PLACE) + "개");
        OutputUtil.println(LottoScore.SECOND_PLACE.getName() + LottoScore.SECOND_PLACE.getValue() + LottoGameUtil.CONTOUR_WITH_BLANK + map.get(LottoScore.SECOND_PLACE) + "개");
        OutputUtil.println(LottoScore.FIRST_PLACE.getName() + LottoScore.FIRST_PLACE.getValue() + LottoGameUtil.CONTOUR_WITH_BLANK + map.get(LottoScore.FIRST_PLACE) + "개");
        OutputUtil.printf(LottoGameMessage.RATE_OF_RETURN, getRateOfReturn(purchaseAmount));
    }
}
