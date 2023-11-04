package lotto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Lotto;

import java.util.List;
import lotto.domain.Rank;

public class OutputView {

    public void printRequestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printRequestWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printNumberOfLottosPurchased(int numberOfLottos) {
        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResults(Map<Rank, Integer> results) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.FAIL) {
                continue;
            }

            String prizeMoneyFormatted = numberFormat.format(rank.getWinningMoney());
            if (rank == Rank.SECOND) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", prizeMoneyFormatted, results.getOrDefault(rank, 0));
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getMatchCount(), prizeMoneyFormatted, results.getOrDefault(rank, 0));
        }
    }

    public void printProfitRate(double profitRate) {
        DecimalFormat profitFormat = new DecimalFormat("#.##");
        System.out.printf("총 수익률은 %s%%입니다.\n", profitFormat.format(profitRate));
    }
}
