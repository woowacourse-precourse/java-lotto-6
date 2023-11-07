package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void displayMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public void displayLottoTicket(OutputMessage message, int ticketCount, List<Lotto> lottoTicket) {
        System.out.println(ticketCount + message.getMessage());
        System.out.println(lottoTicket);
    }

    public void displayResult(OutputMessage message, Map<String, Integer> lottoResult, double profit) {
        System.out.println(message.getMessage());
        List<Map.Entry<String, Integer>> sortedResult = sortResult(lottoResult);

        for (Map.Entry<String, Integer> entry : sortedResult) {
            displaySingleLottoResult(entry);
        }

        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    private List<Map.Entry<String, Integer>> sortResult(Map<String, Integer> lottoResult) {
        List<Map.Entry<String, Integer>> sortedResult = lottoResult.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
        return sortedResult;
    }

    private void displaySingleLottoResult(Map.Entry<String, Integer> entry) {
        int matchCount = LottoRank.getMatchingCountByRank(entry.getKey());
        long prize = LottoRank.getPrizeByRank(entry.getKey());

        String rankFormat = formatRank(matchCount, entry.getKey());
        String prizeFormat = formatPrize(prize);
        String countFormat = formatCount(entry.getValue());

        System.out.println(rankFormat + prizeFormat + " - " + countFormat);
    }

    private String formatRank(int matchCount, String rank) {
        String format = matchCount + "개 일치";
        if (rank.equals(LottoRank.SECOND_PLACE.getRank())) {
            format += ", 보너스 볼 일치";
        }
        return format;
    }

    private String formatPrize(long prize) {
        String prizeFormat = NumberFormat.getNumberInstance(Locale.US).format(prize);
        return " (" + prizeFormat + "원)";
    }

    private String formatCount(int value) {
        return value + "개";
    }
}