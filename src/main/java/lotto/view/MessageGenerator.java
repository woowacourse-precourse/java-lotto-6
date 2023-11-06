package lotto.view;

import lotto.domain.LottoRanking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static lotto.domain.LottoRanking.*;

public class MessageGenerator {
    private static final String FIRST_STATISTICS_MESSAGE_FORMAT = "6개 일치 (2,000,000,000원) - %d개";
    private static final String SECOND_STATISTICS_MESSAGE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String THIRD_STATISTICS_MESSAGE_FORMAT = "5개 일치 (1,500,000원) - %d개";
    private static final String FOURTH_STATISTICS_MESSAGE_FORMAT = "4개 일치 (50,000원) - %d개";
    private static final String FIFTH_STATISTICS_MESSAGE_FORMAT = "3개 일치 (5,000원) - %d개";

    private static Map<String, Function<Integer, String>> generator = new HashMap<>();

    static {
        addMessageFormatOf(FIRST, FIRST_STATISTICS_MESSAGE_FORMAT);
        addMessageFormatOf(SECOND, SECOND_STATISTICS_MESSAGE_FORMAT);
        addMessageFormatOf(THIRD, THIRD_STATISTICS_MESSAGE_FORMAT);
        addMessageFormatOf(FOURTH, FOURTH_STATISTICS_MESSAGE_FORMAT);
        addMessageFormatOf(FIFTH, FIFTH_STATISTICS_MESSAGE_FORMAT);
    }

    private static void addMessageFormatOf(LottoRanking lottoRanking, String messageFormat) {
        generator.put(lottoRanking.name(), count -> String.format(messageFormat, count));
    }

    public List<String> generateStatisticsMessages(Map<String, Integer> result, List<String> lottoRankingOutputOrder) {
        return lottoRankingOutputOrder.stream()
                .map(lottoRanking -> generateStatisticsMessage(result, lottoRanking))
                .toList();
    }

    private String generateStatisticsMessage(Map<String, Integer> result, String lottoRanking) {
        int count = result.getOrDefault(lottoRanking, 0);

        return generator.get(lottoRanking).apply(count);
    }
}
