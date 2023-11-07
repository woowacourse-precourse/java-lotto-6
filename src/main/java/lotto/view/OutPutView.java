package lotto.view;

import static lotto.view.IOMessage.PRINT_EARNING_RATE;
import static lotto.view.IOMessage.PRINT_ERROR_MESSAGE_START;
import static lotto.view.IOMessage.PRINT_PURCHASED_LOTTO;
import static lotto.view.IOMessage.PRINT_WINNING_RATE;
import static lotto.view.IOMessage.PRINT_WINNING_RATE_WITH_BONUS_NUMBER;
import static lotto.view.IOMessage.PRINT_WINNING_STATS;

import java.util.List;
import java.util.StringJoiner;
import lotto.model.LottoRank;

public class OutPutView {

    private OutPutView() {}

    public static void printIOMessage(IOMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoRanks(List<LottoRank> lottoRanks) {
        System.out.println(PRINT_WINNING_STATS.getMessage());

        lottoRanks.forEach(OutPutView::printLottoRank);
    }

    public static void printEarningRate(Double earningRate) {
        String earningRateMessage = String.format(PRINT_EARNING_RATE.getMessage(), earningRate);
        System.out.println(earningRateMessage);
    }

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        String purchaseCountMessage = String.format(PRINT_PURCHASED_LOTTO.getMessage(), lottoNumbers.size());
        System.out.println(purchaseCountMessage);
        lottoNumbers.forEach(OutPutView::printLotto);
    }

    public static void printErrorMessage(String message) {
        String errorMessage = String.format(PRINT_ERROR_MESSAGE_START.getMessage(), message);
        System.out.println(errorMessage);
    }

    private static void printLottoRank(LottoRank lottoRank) {

        if(lottoRank.equals(LottoRank.SECOND)) {
            printSecondRankMessage(lottoRank);
            return;
        }

        String rankMessage = getRankMessage(lottoRank);
        System.out.println(rankMessage);
    }

    private static String getRankMessage(LottoRank lottoRank) {
        return String.format(PRINT_WINNING_RATE.getMessage(),
                lottoRank.getMatchingCount(),
                lottoRank.getPrizeAmount(),
                lottoRank.getWinningCount());
    }

    private static void printSecondRankMessage(LottoRank lottoRank) {
        String rankMessage = String.format(PRINT_WINNING_RATE_WITH_BONUS_NUMBER.getMessage(),
                lottoRank.getMatchingCount(),
                lottoRank.getPrizeAmount(),
                lottoRank.getWinningCount());

        System.out.println(rankMessage);
    }

    private static void printLotto(List<Integer> lottoNumbers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lottoNumbers.forEach(number -> joiner.add(number.toString()));

        System.out.println(joiner.toString());
    }

}
