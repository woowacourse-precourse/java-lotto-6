package lotto.view;

public class OutputView {
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String EMPTY_LINE = "\n";

    public void askForPurchaseAmount() {
        System.out.println(LOTTO_START_MESSAGE);
    }

    public void answerForPurchase(int lottoCount, String lottoNumbers) {
        System.out.print(EMPTY_LINE);
        System.out.printf("%d" + LOTTO_BUY_MESSAGE, lottoCount);
        System.out.print(EMPTY_LINE);
        System.out.println(lottoNumbers);

    }
}
