package lotto.domain.constants;

import lotto.domain.Lottos;

import java.text.NumberFormat;
import java.util.*;

public enum LottoPrizeRule {
    FIFTH_PRIZE(5, 3, false, 5_000),
    FOURTH_PRIZE(4, 4, false, 50_000),
    THIRD_PRIZE(3, 5, false, 1_500_000),
    SECOND_PRIZE(2, 5, true, 30_000_000),
    FIRST_PRIZE(1, 6, false, 2_000_000_000);

    private final int place;
    private final int matchedNumbersCount;
    private final boolean hasBonusNumber;
    private final int prize;
    private static final StringBuilder resultMessage = new StringBuilder();

    LottoPrizeRule(int place, int matchedNumbersCount, boolean hasBonusNumber, int prize) {
        this.place = place;
        this.matchedNumbersCount = matchedNumbersCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static void initWinningStatistics(Map<Integer, Integer> winningStatistics) {
        Arrays.stream(LottoPrizeRule.values())
                .forEach(prizeRule -> winningStatistics.put(prizeRule.place, 0));
    }

    public static int findPlaceByRule(int lottoMatchedNumbersCount, boolean hasLottoBonusNumber) {
        int place = 0;

        List<LottoPrizeRule> matchedPlaceByCount = Arrays.stream(LottoPrizeRule.values())
                .filter(prizeRule -> prizeRule.hasSameCount(lottoMatchedNumbersCount))
                .toList();

        if (matchedPlaceByCount.isEmpty()) {
            return place;
        }

        place = matchedPlaceByCount.get(0).place;

        if (matchedPlaceByCount.size() == 2 && hasLottoBonusNumber) {
            place = matchedPlaceByCount.get(1).place;
        }

        return place;
    }

    public static int findPrizeByPlace(int lottoPlace) {
        int prize = 0;

        Optional<LottoPrizeRule> matchedPrize = Arrays.stream(LottoPrizeRule.values())
                .filter(place -> place.place == lottoPlace)
                .findAny();

        if (matchedPrize.isPresent()) {
            prize = matchedPrize.get().prize;
        }

        return prize;
    }

    private boolean hasSameCount(int matchedNumbersCount) {
        return this.matchedNumbersCount == matchedNumbersCount;
    }


    public static String getWinningStatisticsMessage(Lottos lottos) {
        Arrays.stream(LottoPrizeRule.values())
                .forEach(place -> {
                    resultMessage.append(place.formatMessage(OutputViewMessage.MATCHED_NUMBERS_COUNT.getMessage(),
                            place.matchedNumbersCount));

                    if (place.hasBonusNumber) {
                        resultMessage.append(OutputViewMessage.BONUS_NUMBER.getMessage());
                    }

                    resultMessage.append(place.formatMessage(OutputViewMessage.PRIZE.getMessage(), place.prize));
                    resultMessage.append(place.formatMessage(OutputViewMessage.LOTTO_COUNT.getMessage(),
                            lottos.getLottoCountByPlace(place.place)));
                    resultMessage.append("\n");
                });
        return resultMessage.toString();
    }

    private String formatMessage(String message, int value) {
        if (value == prize) {
            return String.format(message, NumberFormat.getNumberInstance().format(value));
        }
        return String.format(message, value);
    }
}