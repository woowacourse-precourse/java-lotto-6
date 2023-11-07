package lotto.view;


import lotto.domain.common.Lotto;
import lotto.domain.common.Rank;
import lotto.domain.consumer.Consumer;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private final static String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String PRODUCER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String PRODUCER_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private final static String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---";
    private final static String WINNING_PRIZE_RATIO_MESSAGE_FORMER = "총 수익률은 ";
    private final static String WINNING_PRIZE_RATIO_MESSAGE_LATTER = "%입니다.";

    public void printPriceMessage() {
        System.out.println(PRICE_MESSAGE);
    }

    public void printCountMessage(Consumer consumer) {
        int count = consumer.consumerLottos().size();
        System.out.println("\n" + count + COUNT_MESSAGE);
    }

    public void printConsumerNumbers(Consumer consumer) {
        for (Lotto lotto : consumer.consumerLottos()) {
            List<Integer> numbers = lotto.numbers();
            List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
            System.out.println(sorted);
        }
        System.out.println();
    }

    public void printProducerLottoMessage() {
        System.out.println(PRODUCER_NUMBER_MESSAGE);
    }

    public void printProducerBonusMessage() {
        System.out.println(PRODUCER_BONUS_MESSAGE);
    }

    public void printWinningResultMessage() {
        System.out.println(WINNING_RESULT_MESSAGE);
    }

    public void printWinningProfitRatioMessage(double profitRatio) {
        System.out.print(WINNING_PRIZE_RATIO_MESSAGE_FORMER + profitRatio + WINNING_PRIZE_RATIO_MESSAGE_LATTER);
    }

    public void printWinningResult(Rank rank, int count) {
        System.out.println(rank.getInfo() + " - " + count + "개");
    }
}
