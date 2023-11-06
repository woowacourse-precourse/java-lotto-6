package lotto.view;

public class OutputView {
    public static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printLottoAmount(int count) {
        System.out.println(count + LOTTO_AMOUNT_MESSAGE);
    }

}
