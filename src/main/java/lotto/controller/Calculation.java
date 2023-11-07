package lotto.controller;

import lotto.model.GameEnvironment;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Prize;
import java.util.Collections;
import java.util.List;

public class Calculation {

    private static final int TICKET_PRICE = GameEnvironment.TICKET.getValue();

    public int countMatching (Lotto lotto, LottoTicket ticket) {
        int matchCount = 0;
        int[] counts = countMatchingNumbers(lotto,ticket);

        for(int count : counts) {
            if(count != 0) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public int[] countMatchingNumbers(Lotto lotto, LottoTicket ticket) {
        int count[] = new int[ticket.getTickets()];

        for(int i = 0; i < ticket.getTickets(); i++) {
            checkMatching(lotto.getNumbers(), ticket.getTicketNumbers().get(i), count);
        }

        return count;
    }

    private void checkMatching(List<Integer> input, List<Integer> ticket, int[] count) {

        for(int j = 0; j < maxNumber(input,ticket)+1; j++) {
            int match = 0;

            if(input.get(j).equals(ticket.get(j))) {
                match++;
            }

            count[j]=match;
        }
    }

    public int maxNumber(List<Integer> input, List<Integer> ticket) {
        int max = 0;
        input.sort(Collections.reverseOrder());

        for(int i = 0; i < 6; i++) {
            if (input.get(0) >= ticket.get(i)) {
                max = i;
            }
        }

        return max;
    }

    public Boolean isMatchBonusNumber(Lotto lotto, LottoTicket ticket) {
        for(List<Integer> numbers : ticket.getTicketNumbers()) {
            if(numbers.contains(bonusNumber())){
                return false;
            }
        }
        return true;
    }

    public double calculateProfitRate(Lotto lotto, LottoTicket ticket){
        int purchaseAmount = TICKET_PRICE*ticket.getTickets();
        int winningPrize = 0;
        int count = countMatching(lotto, ticket);

        for(Prize prize : Prize.values()) {
            if(count == prize.getMatchingNumbers()) {
                winningPrize = prize.getPrizeAmount();
            }
        }

        if(count == 5 && !isMatchBonusNumber(lotto, ticket)){
            winningPrize = Prize.MATCH_5_WITH_BONUS.getPrizeAmount();
        }

        double profitRate = (double) winningPrize / purchaseAmount * 100.0;
        profitRate = Math.round(profitRate * 100.0) / 100.0;

        return profitRate;
    }

}
