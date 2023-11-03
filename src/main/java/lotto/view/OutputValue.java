package lotto.view;

public class OutputValue {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";


    public static void purchaseMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public static void lottoCountMessage(int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

}
