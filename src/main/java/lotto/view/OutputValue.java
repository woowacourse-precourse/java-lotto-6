package lotto.view;

import java.util.List;

public class OutputValue {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE_BREAK = "---";

    public static void purchaseMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public static void lottoCountMessage(int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void purchaseLottoMessage(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public static void changeLine() {
        System.out.println();
    }

    public static void winLottoNumberMessage() {
        System.out.println(WIN_LOTTO_NUMBER_MESSAGE);
    }

    public static void bonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void winStatisticsMessage() {
        System.out.println(WIN_STATISTICS_MESSAGE);
        System.out.println(LINE_BREAK);
    }
}
