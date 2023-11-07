package lotto.view;

import lotto.domain.Price;

public class OutputLottoCountView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottoCount(Price price){
        int purchasedCount = price.getPrice();
        System.out.println((String.format(LOTTO_COUNT_MESSAGE, purchasedCount)));
    }
}
