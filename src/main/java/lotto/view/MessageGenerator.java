package lotto.view;

import lotto.domain.LottoRanking;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static lotto.domain.LottoRanking.*;

public class MessageGenerator {
    private static final String STATISTICS_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_STATISTICS_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PRIZE_MONEY_PATTERN = "###,###";
    private static final int INITIAL_COUNT = 0;

    private static Map<String, Function<Integer, String>> generator = new HashMap<>();

    static {
        addMessageFormatOf(FIRST);
        addMessageFormatOf(SECOND);
        addMessageFormatOf(THIRD);
        addMessageFormatOf(FOURTH);
        addMessageFormatOf(FIFTH);
    }

    private static void addMessageFormatOf(LottoRanking lottoRanking) {
        generator.put(lottoRanking.name(), count -> getFormat(lottoRanking, count));
    }

    private static String getFormat(LottoRanking lottoRanking, Integer count) {
        int numberOfMatches = lottoRanking.getNumberOfMatches();
        String prizeMoneyMessage = generatePrizeMoneyMessage(lottoRanking);

        if (lottoRanking.isSecond()) {
            return String.format(SECOND_STATISTICS_MESSAGE_FORMAT, numberOfMatches, prizeMoneyMessage, count);
        }
        return String.format(STATISTICS_MESSAGE_FORMAT, numberOfMatches, prizeMoneyMessage, count);
    }

    private static String generatePrizeMoneyMessage(LottoRanking lottoRanking) {
        DecimalFormat decimalFormat = new DecimalFormat(PRIZE_MONEY_PATTERN);
        return decimalFormat.format(lottoRanking.getPrizeMoney());
    }

    public List<String> generateStatisticsMessages(Map<String, Integer> result, List<String> lottoRankingOutputOrder) {
        return lottoRankingOutputOrder.stream()
                .map(lottoRanking -> generateStatisticsMessage(result, lottoRanking))
                .toList();
    }

    private String generateStatisticsMessage(Map<String, Integer> result, String lottoRanking) {
        int count = result.getOrDefault(lottoRanking, INITIAL_COUNT);

        return generator.get(lottoRanking).apply(count);
    }
}
