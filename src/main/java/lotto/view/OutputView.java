package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.HashMap;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s"+"\n";
    private static final String PURCHASE_QUANTITY_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_WINNING_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PROFITRATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n" + "---";

    public static void errorMessage(IllegalArgumentException e) {
        System.out.printf(ERROR_MESSAGE_FORMAT,e.getMessage());
    }

    public static void purchaseResults(List<Lotto> userLottos) {
        printPurchaseQuantity(userLottos);
        printLottoNumbers(userLottos);
    }

    public static void lottoResults(HashMap<LottoRank, Integer> winningRankCount, double profitRate) {
        System.out.println(WINNING_STATISTICS);
        printWinningStatistics(winningRankCount);
        printProfitRate(profitRate);
    }

    private static void printPurchaseQuantity(List<Lotto> userLottos) {
        int purchaseQuantity = userLottos.size();
        System.out.printf(PURCHASE_QUANTITY_MESSAGE_FORMAT,purchaseQuantity);
    }

    private static void printLottoNumbers(List<Lotto> userLottos) {
        userLottos.stream().forEach(System.out::println);
    }

    private static void printWinningStatistics(HashMap<LottoRank, Integer> winningRankCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.equals(LottoRank.SECOND)) {
                System.out.printf(SECOND_WINNING_FORMAT,lottoRank.getRankMatchCount(),lottoRank.getPrizeAsString(), winningRankCount.getOrDefault(lottoRank, ZERO));
                continue;
            }
            System.out.printf(WINNING_RESULT_FORMAT,lottoRank.getRankMatchCount(),lottoRank.getPrizeAsString(), winningRankCount.getOrDefault(lottoRank,ZERO));
        }
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf(PROFITRATE_FORMAT, profitRate);
    }
}
