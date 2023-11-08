package lotto.view;

import lotto.domain.prize.Prize;

public class OutputView {
    private static final String ERROR = "[ERROR] ";
    public void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }


    public void printExceptionMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void lottos(int ticketCount, String lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", ticketCount);
        System.out.println(lottos);
    }

    public void winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void winningStats() {
        System.out.println("당첨 통계\n---\n");
    }

    public void prizeResult(Prize prize, int resultCount) {
        System.out.printf("%s - %d개\n", prize.getMessage(), resultCount);
    }

    public void earningsRate(float earningsRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRate);
    }
}
