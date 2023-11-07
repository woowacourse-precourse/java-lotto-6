package lotto.view;


public class OutputView {
    private static final String BUY_LOTTO = "구입금액을 입력해 주세요";

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
    public void printBuyLotto() {
        System.out.println(BUY_LOTTO);
    }
}
