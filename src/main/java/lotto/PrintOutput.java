package lotto;

import static lotto.MatchCountMessage.COUNT_NUMBER;
import static lotto.NoticeMessage.BUY_COUNT;
import static lotto.NoticeMessage.RATE_OF_RETURN_HEAD;
import static lotto.NoticeMessage.RATE_OF_RETURN_TAIL;

public class PrintOutput {
    public static void printNoticeMessage(NoticeMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printRateOfReturn(int rate) {
        System.out.println(RATE_OF_RETURN_HEAD.getMessage() + rate + RATE_OF_RETURN_TAIL.getMessage());

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
        System.out.println();
    }

    public static void printMatchCountMessage(MatchCountMessage message, int count) {
        System.out.println(message.getMessage() + count + COUNT_NUMBER.getMessage());
        System.out.println();
    }
}
