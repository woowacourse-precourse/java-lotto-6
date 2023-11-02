package lotto.io;

import java.util.List;

public class Output {

    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printMyLottoCount(int money) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.", money/1000);
        System.out.println();
    }

    public void printInputWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printMyLottos(List<String> myLottosForPrint) {
        myLottosForPrint.forEach(System.out::println);
        System.out.println();
    }

    public void printWinningResult(List<Integer> winningLottos, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winningLottos.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winningLottos.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winningLottos.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningLottos.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winningLottos.get(0));
        System.out.printf("총 수익률은 %.1f%%", profitRate);
    }
}
