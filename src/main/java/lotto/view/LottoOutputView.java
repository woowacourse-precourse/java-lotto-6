package lotto.view;

import java.util.Comparator;
import java.util.List;

public final class LottoOutputView {
    private final static String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private LottoOutputView() {
    }

    public static void printPurchasePriceMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        String lottCountMessage = String.format(LOTTO_COUNT_MESSAGE, lottoCount);
        System.out.println(lottCountMessage);
    }

    public static void printLottoNumbers(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            number.sort(Comparator.naturalOrder());
            System.out.println(number);
        }
    }

}
