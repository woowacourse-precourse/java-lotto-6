package lotto.view;


import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {

    public void printMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchase(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResults(Result result) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank.getCorrectNumbers() > 0) {
                String isBonus = "";
                if (rank == Rank.SECOND) {
                    isBonus = ", 보너스 볼 일치 ";
                }
                System.out.printf("%d개 일치%s(%d원)- %d개\n",
                        rank.getCorrectNumbers(), isBonus, rank.getWinnings(),
                        result.getResult().getOrDefault(rank, 0));
            }
        }
    }

    public void printRate(Result result, Money inputMoney) {
        System.out.println("총 수익률은 " + result.calculateRate(inputMoney) + "%입니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
