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
        LottoWinningAmount[] values = LottoWinningAmount.values();
        for (LottoWinningAmount value : values) {
            int n = 0;
            if (winningStatisticsDto.lottoWinningAmount().get(value) != null) {
                n = winningStatisticsDto.lottoWinningAmount().get(value);
            }
            String s = "";
            if (value.getBonus()) {
                s = ", 보너스 볼 일치";
            }
            System.out.printf("%d개 일치%s (%s원) - %d개\n",value.getWinningNumber(),s, String.format("%,d",value.getWinningAmount()),n);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", winningStatisticsDto.yield());
    }


}
