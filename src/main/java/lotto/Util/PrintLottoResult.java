package lotto.Util;

import static lotto.Constant.ConstLottoResult.*;
import static lotto.Constant.LottoMatchResult.*;
import static lotto.Constant.Const.*;



public class PrintLottoResult {

    public void printWinningMessage(){
        System.out.println("\n" + LOTTO_WINNING_RESULT_STATISTICS);
    }

    public void printWinningResult(int lottoMatchNumber, int winningAward, int matchCount){
        String commaWinningAward = String.format("%,d", winningAward);
        if (lottoMatchNumber == MATCH_FIVE_WITH_BONUS.getMatchCount()){
            System.out.printf(LOTTO_MATCH_COUNT_FIVE_WITH_BONUS_RESULT.getPrintResult(), commaWinningAward, matchCount);
            return;
        }
        System.out.printf(LOTTO_MATCH_COUNT_RESULT.getPrintResult(), lottoMatchNumber, commaWinningAward, matchCount);
    }

    public void printTotalWinningReward(double userTotalReward){
        System.out.printf(LOTTO_RESULTS_STATISTICS.getPrintResult(), userTotalReward);
    }
}
