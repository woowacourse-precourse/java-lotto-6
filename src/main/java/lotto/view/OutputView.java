package lotto.view;

import static java.lang.String.format;

public class OutputView {

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE_TEMPLATE = "%s개를 구매했습니다.";

    public void printPurchasedCountMessage(Integer purchasedLottoCount) {
        System.out.println(format(PURCHASED_LOTTO_COUNT_MESSAGE_TEMPLATE, purchasedLottoCount));
    }
}
