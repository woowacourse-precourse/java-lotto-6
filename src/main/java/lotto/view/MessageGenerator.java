package lotto.view;

import lotto.domain.LottoRanking;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MessageGenerator {
    private static final String STATISTICS_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_STATISTICS_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PRIZE_MONEY_FORMAT_PATTERN = "###,###";

    private static final int INITIAL_COUNT = 0;

    private static Map<LottoRanking, Function<Integer, String>> generator = new HashMap<>();

    static {
        addMessageFormatOf(LottoRanking.FIRST);
        addMessageFormatOf(LottoRanking.SECOND);
        addMessageFormatOf(LottoRanking.THIRD);
        addMessageFormatOf(LottoRanking.FOURTH);
        addMessageFormatOf(LottoRanking.FIFTH);
    }

    private static void addMessageFormatOf(LottoRanking lottoRanking) {
        generator.put(lottoRanking, count -> generateMessageFormatOf(lottoRanking, count));
    }

    private static String generateMessageFormatOf(LottoRanking lottoRanking, Integer count) {
        int numberOfMatches = lottoRanking.getNumberOfMatches();
        String prizeMoneyMessage = generatePrizeMoneyMessage(lottoRanking);

        if (lottoRanking.isSecond()) {
            return String.format(SECOND_STATISTICS_MESSAGE_FORMAT, numberOfMatches, prizeMoneyMessage, count);
        }
        return String.format(STATISTICS_MESSAGE_FORMAT, numberOfMatches, prizeMoneyMessage, count);
    }

    private static String generatePrizeMoneyMessage(LottoRanking lottoRanking) {
        DecimalFormat decimalFormat = new DecimalFormat(PRIZE_MONEY_FORMAT_PATTERN);
        return decimalFormat.format(lottoRanking.getPrizeMoney());
    }

    public String generateStatisticsMessage(Map<LottoRanking, Integer> result) {
        List<LottoRanking> outputOrder = LottoRanking.findOrder();

        return outputOrder.stream()
                .map(lottoRanking -> generateMessage(result, lottoRanking))
                .collect(Collectors.joining(OutputView.NEWLINE));
    }

    private String generateMessage(Map<LottoRanking, Integer> result, LottoRanking lottoRanking) {
        int count = result.getOrDefault(lottoRanking, INITIAL_COUNT);

        return generator.get(lottoRanking).apply(count);
    }
}
