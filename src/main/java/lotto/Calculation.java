package lotto;

import java.util.Collections;
import java.util.List;

public class Calculation {

    public int countMatchingNumbers(Lotto lotto, LottoTicket ticket) {
        int count = 0;
        List<Integer> numbers = lotto.getNumbers();
        List<List<Integer>> tickets = ticket.getTicketNumbers();

        for(int i = 0; i < ticket.getTickets(); i++) {
            for(int j = 0; j < maxNumber(numbers,tickets.get(i))+1; j++) {
                checkMatching(numbers.get(j), tickets.get(i), count);
            }
        }

        return count;
    }

    private void checkMatching(int input, List<Integer> ticket, int count) {
        if(ticket.contains(input)) {
            count+=1;
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

    public Boolean isMatchBonusNumber(Lotto lott, LottoTicket ticket) {
        return true;
    }

    public double calculateProfitRate(Lotto lott, LottoTicket ticket){
        return 0.0;
    }
}
