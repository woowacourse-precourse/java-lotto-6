package lotto;

import static lotto.enums.NoticeMessage.BUY_COUNT;
import static lotto.enums.NoticeMessage.RATE_OF_RETURN_HEAD;
import static lotto.enums.NoticeMessage.RATE_OF_RETURN_TAIL;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.enums.MatchCountMessage;
import lotto.enums.NoticeMessage;

public class PrintOutput {
    private static final String COUNT_NUMBER = "개";

    public static void printNoticeMessage(NoticeMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printCountOfLotto(int count) {
        System.out.println();
        System.out.println(count + BUY_COUNT.getMessage());
    }

    public static void printLottos(Lottos lottos) {
        StringBuilder lottoNumbers = new StringBuilder();
        for (int i = 0; i < lottos.size(); i++) {
            lottoNumbers.append(lottos.getIndexLotto(i).toString()).append("\n");
        }
        System.out.println(lottoNumbers);
    }

    public static void printLottosRank(Map<Integer, Integer> winningRanks) {
        List<String> messages = Stream.of(MatchCountMessage.values()).map(MatchCountMessage::getMessage).toList();
        for (int i = 0; i <= 4; i++) {
            printMatchCountMessage(messages.get(i), winningRanks.get(5 - i));
        }
    }

    private static void printMatchCountMessage(String message, int count) {
        System.out.println(message + count + COUNT_NUMBER);
    }

    public static void printRateOfReturn(double rate) {
        System.out.println(
                RATE_OF_RETURN_HEAD.getMessage() + String.format("%.1f", rate) + RATE_OF_RETURN_TAIL.getMessage());

    }
}
