package lotto.control;

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
    private long numOfTicket;
    private long threeMatch;
    private long fourMatch;
    private long fiveMatch;
    private long fiveMatchBonus;
    private long sixMatch;

    public Output(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
        this.numOfTicket = lottoTicket.size();
    }

    public void printOutput(int bonusNumber) {


        for (int i = 0; i < numOfTicket; i++) {
            int count = 0;
            List<Integer> numbers = lottoTicket.get(i).getNumbers();

            for (int j = 0; j < winningNumber.size(); j++) {
                if (numbers.contains(winningNumber.get(j))) {
                    count++;
                }
            }
            if (count < 3) ;
            else if (count == 3) threeMatch++;
            else if (count == 4) fourMatch++;
            else if (count == 5) {
                if (lottoTicket.get(i).getNumbers().contains(bonusNumber)) fiveMatchBonus++;
                else fiveMatch++;
            } else if (count == 6) sixMatch++;
        }

        System.out.println(WINNING_STATISTICS_MSG);
        System.out.println(THREE_BAR_MSG);
        System.out.println(THREE_MATCH_MSG + threeMatch + EA_MSG);
        System.out.println(FOUR_MATCH_MSG + fourMatch + EA_MSG);
        System.out.println(FIVE_MATCH_MSG + fiveMatch + EA_MSG);
        System.out.println(FIVE_MATCH_BONUS_MSG + fiveMatchBonus + EA_MSG);
        System.out.println(SIX_MATCH_MSG + sixMatch + EA_MSG);
        int investment = lottoTicket.size() * 1000;
        long profit = (threeMatch * 5000 + fourMatch * 50000 + fiveMatch * 1500000 + fiveMatchBonus * 30000000 + sixMatch * 2000000000);
        double profitRate = profit / (double)investment * 100;
        double roundedProfitRate = Math.round(profitRate*100.0)/100.0;
        System.out.println(PROFIT_MSG_1 + roundedProfitRate + PROFIT_MSG_2);
    }
}
