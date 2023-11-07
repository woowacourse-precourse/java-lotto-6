package lotto.view;

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
        Map<Ranking, Integer> winningResultMap = prizeResult.getPrizeResult();
        StringBuilder stringBuilder = new StringBuilder();

        resultIntro(stringBuilder);

        for (Map.Entry<Ranking, Integer> entry : winningResultMap.entrySet()) {
            Ranking ranking = entry.getKey();
            int count = entry.getValue();
            generateResultContent(ranking, count, stringBuilder);
        }
        System.out.println(stringBuilder);
    }

    private static void generateResultContent(Ranking ranking, int count, StringBuilder stringBuilder) {
        String countSentence = String.format("%d개 일치", ranking.getCount());
        stringBuilder.append(countSentence);

        if (ranking.getHasBonusBall()) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        String str = String.format("(%d원)- %d개%s", ranking.getPrize(), count, LINE_SEPARATOR);
        stringBuilder.append(str);
    }

    private static void resultIntro(StringBuilder stringBuilder) {
        stringBuilder.append("당첨 통계")
                .append(LINE_SEPARATOR)
                .append("---------")
                .append(LINE_SEPARATOR);
    }
}
