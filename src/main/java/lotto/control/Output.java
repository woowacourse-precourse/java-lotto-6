package lotto.control;

import lotto.constants.WinningPrize;
import lotto.lottoMaker.Lotto;

import java.util.List;

import static lotto.constants.Constants.THREE_BAR_MSG;
import static lotto.constants.Constants.WINNING_STATISTICS_MSG;
import static lotto.constants.Constants.THREE_MATCH_MSG;
import static lotto.constants.Constants.FOUR_MATCH_MSG;
import static lotto.constants.Constants.FIVE_MATCH_MSG;
import static lotto.constants.Constants.FIVE_MATCH_BONUS_MSG;
import static lotto.constants.Constants.SIX_MATCH_MSG;
import static lotto.constants.Constants.EA_MSG;
import static lotto.constants.Constants.PROFIT_MSG_1;
import static lotto.constants.Constants.PROFIT_MSG_2;

public class Output {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;

    public Output(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }

    public void printOutput(int bonusNumber) {
        long[] MatchCount = calculateMatchCount(bonusNumber);
        double roundedProfitRate = getRoundedProfitRate(MatchCount[0], MatchCount[1],MatchCount[2], MatchCount[3], MatchCount[4]);
        printResult(roundedProfitRate, MatchCount[0], MatchCount[1],MatchCount[2], MatchCount[3], MatchCount[4]);

    }
    private long[] calculateMatchCount(int bonusNumber) {
        long[] Count = {0L,0L,0L,0L,0L};
        long numOfTicket = lottoTicket.size();
        for (int i = 0; i < numOfTicket; i++) {
            int count = 0;
            List<Integer> numbers = lottoTicket.get(i).getNumbers();
            for (int j = 0; j < winningNumber.size(); j++) {
                if (numbers.contains(winningNumber.get(j))) {
                    count++;
                }
            }
            countTicker(i, count, bonusNumber, Count);
        }
        return Count;
    }

    private void countTicker(int index, int count, int bonusNumber, long[] Count) {
        if (count == 3) Count[0]++;
        if (count == 4) Count[1]++;
        if (count == 5 && !lottoTicket.get(index).getNumbers().contains(bonusNumber)) Count[2]++;
        if (count == 5 && !lottoTicket.get(index).getNumbers().contains(bonusNumber)) Count[3]++;
        if (count == 6) Count[4]++;
    }

    private double getRoundedProfitRate(long threeMatch,
                                        long fourMatch,
                                        long fiveMatch,
                                        long fiveMatchBonus,
                                        long sixMatch) {
        int investment = lottoTicket.size() * 1000;
        long profit = getProfit(threeMatch, fourMatch, fiveMatch, fiveMatchBonus, sixMatch);
        double profitRate = profit / (double)investment * 100;
        double roundedProfitRate = Math.round(profitRate*100.0)/100.0;
        return roundedProfitRate;
    }

    private long getProfit(long threeMatch,
                           long fourMatch,
                           long fiveMatch,
                           long fiveMatchBonus,
                           long sixMatch) {
        long profit = (threeMatch * WinningPrize.THREEMATCH.getPrize() +
                fourMatch * WinningPrize.FOURMATCH.getPrize() +
                fiveMatch * WinningPrize.FIVEMATCH.getPrize() +
                fiveMatchBonus * WinningPrize.FIVEMATCHBONUS.getPrize() +
                sixMatch * WinningPrize.SIXMATCH.getPrize());
        return profit;
    }

    public void printResult(double roundedProfitRate,
                            long threeMatch,
                            long fourMatch,
                            long fiveMatch,
                            long fiveMatchBonus,
                            long sixMatch) {
        System.out.println(WINNING_STATISTICS_MSG);
        System.out.println(THREE_BAR_MSG);
        System.out.println(THREE_MATCH_MSG + threeMatch + EA_MSG);
        System.out.println(FOUR_MATCH_MSG + fourMatch + EA_MSG);
        System.out.println(FIVE_MATCH_MSG + fiveMatch + EA_MSG);
        System.out.println(FIVE_MATCH_BONUS_MSG + fiveMatchBonus + EA_MSG);
        System.out.println(SIX_MATCH_MSG + sixMatch + EA_MSG);
        System.out.println(PROFIT_MSG_1 + roundedProfitRate + PROFIT_MSG_2);
    }



}
