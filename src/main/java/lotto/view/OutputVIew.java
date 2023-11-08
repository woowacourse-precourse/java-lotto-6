package lotto.view;

import java.util.List;
import lotto.congin.LottoWinningAmount;
import lotto.domain.Lotto;
import lotto.dto.WinningStatisticsDto;

public class OutputVIew {

    public void printForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printUserLottoList(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n",lottos.size());
        for (Lotto lotto : lottos) {
            System.out.printf("%s \n",lotto.toString());
        }
    }

    public void printWinningNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        System.out.println("당첨 통계\n" + "---");

        for (LottoWinningAmount value : LottoWinningAmount.values()) {
            int numberOfMatches = winningStatisticsDto.lottoWinningAmount().getOrDefault(value, 0);
            String bonusInfo = value.getBonus() ? ", 보너스 볼 일치" : "";
            String formattedAmount = String.format("%,d", value.getWinningAmount());
            System.out.printf("%d개 일치%s (%s원) - %d개%n", value.getWinningNumber(), bonusInfo, formattedAmount, numberOfMatches);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningStatisticsDto.yield());
    }


}
