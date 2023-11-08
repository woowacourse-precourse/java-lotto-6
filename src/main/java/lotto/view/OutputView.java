package lotto.view;

import lotto.domain.Consumer;

public class OutputView {

    public void printLottos(Consumer consumer){
        System.out.println(consumer.getPurchaseAmount() + "개를 구매했습니다.");
        consumer.getLottos()
                .forEach(System.out::println);
    }
}
