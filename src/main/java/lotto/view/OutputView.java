package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class OutputView {
    private static void printMessage(String message){
        System.out.println(message);
    }
    public static void printPaymentMessage(){
        printMessage(OutputViewMessage.PAYMENT.getMessage());
    }
    public static void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
    public static void printWinningDrawMessage(){
        printMessage(OutputViewMessage.WINNING_DRAW.getFormattedMessage());
    }
    public static void printBonusDrawMessage(){
        printMessage(OutputViewMessage.BONUS_DRAW.getFormattedMessage());
    }
    public static void printLottoPaperMessage(LottoPaper lottoPaper){
        int ticketCount = lottoPaper.lottoTickets().size();
        List<Lotto> lottoTickets = lottoPaper.lottoTickets();
        printMessage(OutputViewMessage.PURCHASED_TICKETS_COUNT.getFormattedMessage(ticketCount));
        for (Lotto lotto : lottoTickets){
            printMessage(lotto.getNumbers().toString());
        }
    }
    public static void printLottoResultMessage(LottoResult lottoResult) {
        printMessage(OutputViewMessage.RESULT.getMessage());
        printMessage(OutputViewMessage.DOTTED_LINE.getMessage());
        EnumMap<LottoRank, Integer> lottoResultBoard = lottoResult.lottoResultBoard();
        printEachLottoRankMessage(lottoResultBoard);
    }
    private static void printEachLottoRankMessage(EnumMap<LottoRank, Integer> lottoResultBoard) {
        LottoRank[] ranks = LottoRank.values();
        for (int i = 0; i < ranks.length - 1; i++) {

            LottoRank lottoRank = ranks[i];
            int resultCount = lottoResultBoard.getOrDefault(lottoRank, 0);
            String rankMessage = formatRankMessage(lottoRank, resultCount);

            printMessage(rankMessage);
        }
    }

    private static String formatRankMessage(LottoRank lottoRank, int resultCount) {
        int matchCount = lottoRank.getMatchCount();
        String bonus = lottoRank.isMatchBonus() ? ", 보너스 볼 일치 " : " ";
        String formattedRankPrize =
                String.format("%,d", LottoPrize.determinePrizeAmountByRank(lottoRank));

        return OutputViewMessage.RANK_COUNT.getFormattedMessage
                (matchCount, bonus, formattedRankPrize, resultCount);
    }
}
