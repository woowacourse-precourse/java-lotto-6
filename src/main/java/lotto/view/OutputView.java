package lotto.view;


import lotto.domain.common.Lotto;
import lotto.domain.consumer.Consumer;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private final static String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String PRODUCER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

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
}
