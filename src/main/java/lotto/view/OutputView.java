package lotto.view;

public class OutputView {

    private OutputView() {

    }

    protected void printReadPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    protected void printPurchaseLottoCountMessage(int purchaseLottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", purchaseLottoCount);
    }

    protected void printReadLottoNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
