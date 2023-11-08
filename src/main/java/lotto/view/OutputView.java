package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printCountPurchaseLottoMessage(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
  
    public void printWinningLotteryNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
  
    public void printInputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printResultMessage(Map<LottoRank, Integer> results) {
        System.out.println("\n당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                String resultMessage = createResultMessage(rank, results.getOrDefault(rank, 0));
                System.out.println(resultMessage);
            }
        }
    }

    private static String createResultMessage(LottoRank rank, int count) {
        String resultMessage = "";
        if (rank == LottoRank.FIVE_MATCH_WITH_BONUS) {
            return resultMessage = String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", rank.getMatchCount(), winningMoneyFormat(rank.getWinningMoney()), count);
        }
        resultMessage = String.format("%d개 일치 (%s원) - %d개", rank.getMatchCount(), winningMoneyFormat(rank.getWinningMoney()), count);
        return resultMessage;
    }

    private static String winningMoneyFormat(int winningMoney) {
        return String.format("%,d", winningMoney);
    }

    public void printRateOfReturnMessage(int purchaseAmount, int totalWinningMoney) {
        double rateOfReturn = (double)(totalWinningMoney) / purchaseAmount * 100;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

}
