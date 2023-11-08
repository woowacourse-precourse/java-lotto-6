package lotto.view;

public class LottoView {

    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_QUANTITY_MESSAGE = "%s개를 구매했습니다.";

    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "%s";

    public void printEmptyLine() {
        System.out.println();
    }

    public void printAskInputAmount() {
        System.out.println(INPUT_AMOUNT);
    }

    public void printQuantityLotto(String lottoQuantity) {
        System.out.printf(PURCHASED_LOTTO_QUANTITY_MESSAGE, lottoQuantity);
        printEmptyLine();
    }

    public void printAskInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void printAskInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printLottoNumber(String lottoNumber) {
        System.out.printf(LOTTO_NUMBER_MESSAGE, lottoNumber);
    }

    public void printTotalProfitRate(String totalProfitRate) {
        System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
    }
}
