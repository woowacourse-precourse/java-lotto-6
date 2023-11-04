package lotto.view;

public class OutputView {
    public static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void displayLottoCount(long lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASE_MESSAGE);
    }
}
