package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeResult;
import lotto.domain.Ranking;
import lotto.domain.TicketPurchaseAmount;

public class OutputView {
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSE_BRACKET = "]";
    public static final String BLANK = " ";
    public static final String DELIMITER = ",";
    public static final String TICKET_PURCHASE_SENTENCE = "개를 구매했습니다.";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private OutputView() {
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public static void printTicket(LottoTicket  lottoTickets) {
        List<Lotto> lottoNumbersList = lottoTickets.getLottoTickets();

        for (Lotto lottoNumbers : lottoNumbersList) {
            List<Integer> lottoNumberList = lottoNumbers.number();
            String sentence = joinList(convertNumberListToStringList(lottoNumberList));
            System.out.println(sentence);
        }
    }

    private static String joinList(List<String> list) {
        return "[" + String.join(", ", list) + "]";
    }

    private static List<String> convertNumberListToStringList(List<Integer> numberList) {
        return numberList.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }
    public static void printWinningStatistic(PrizeResult prizeResult) {
        Map<Ranking, Integer> winningResultMap = prizeResult.newPrizeResult();
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(Ranking.values())
                .sorted(Ranking.sortByPrizeDescending())
                .forEach(ranking -> generateResultContent(ranking, winningResultMap.getOrDefault(ranking, 0), stringBuilder));

        System.out.println(stringBuilder);
    }


    private static void generateResultContent(Ranking ranking, int count, StringBuilder stringBuilder) {
        String resultContent = ranking.formatPrizeInfo(count) + " - " + count + "개";
        stringBuilder.append(resultContent).append(System.lineSeparator());
    }
    public static void printProfit(double profit) {
        String sentence = String.format("총 수익률은 %.1f%%입니다.", profit * 100);
        System.out.println(sentence);
    }
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
