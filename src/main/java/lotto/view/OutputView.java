package lotto.view;

public class OutputView {

    public void printBuyLottoMessage(int tickets) {
        String message = String.format("\n%s개를 구매했습니다.", tickets);
        System.out.println(message);
    }

    public void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public void printPrizeResult(String prizeResult) {
        System.out.print(prizeResult);
    }

    public void printPrizeResultMessage() {
        System.out.println("\n당첨 통계\n---");

    }

    public void printRevenue(String revenue) {
        String message = String.format("총 수익률은 %s입니다.", revenue);
        System.out.println(message);
    }

    public void printRequestMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printRequestWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
