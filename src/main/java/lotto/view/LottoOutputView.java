package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinningStatistics;

import java.util.List;
import java.util.Map;

public class LottoOutputView {

    public void purchasePricePrint(String purchasePrice){
        System.out.println(purchasePrice+"\n");

    }
    public void purchaseAmountPrint(int purchaseAmount){
        System.out.printf(LottoMessage.PURCHASE_AMOUNT_OUTPUT_MESSAGE.getMessage(), purchaseAmount);
    }

    public void lottoTicketsPrint(LottoGame lottoGame, int purchaseAmount){

        List<Lotto> lottoTickets = lottoGame.getLottoTickets();

        for (Lotto lotto : lottoTickets) {

            System.out.println(lotto.getLottoNumbers().toString());
        }
    }


    public void winningNumbersPrint(String winningNumbers){
        System.out.println(winningNumbers+"\n");
    }


    public void bonusNumberPrint(String bonusNumber){
        System.out.println(bonusNumber);
    }

    public void lottoWinningPrizeResultPrint(Map<WinningStatistics, Integer> totalStatistics){

        System.out.printf(LottoMessage.WINNING_PRIZE_RESULT_OUTPUT_MESSAGE.getMessage(),totalStatistics.get(WinningStatistics.THREE_MATCH).intValue(),
                totalStatistics.get(WinningStatistics.FOUR_MATCH).intValue(),totalStatistics.get(WinningStatistics.FIVE_MATCH).intValue()
                ,totalStatistics.get(WinningStatistics.FIVE_BONUS_MATCH).intValue(),totalStatistics.get(WinningStatistics.SIX_MATCH).intValue());
    }

    public void lottoWinningPrizeRatePrint(double winningPrizeRate){
        System.out.printf(LottoMessage.TOTAL_RETURN_RATE_OUTPUT_MESSAGE.getMessage(), winningPrizeRate);
    }



}
