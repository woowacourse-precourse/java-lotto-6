package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculation {

    public int countMatchingNumbers(Lotto lotto, LottoTicket ticket) {
        int count = 0;
        List<Integer> numbers = new ArrayList<>();
        List<List<Integer>> tickets = new ArrayList<>();

        numbers = lotto.getNumbers();
        tickets = ticket.getTicketNumbers();


        return count;
    }

    public int maxNumber(List<Integer> input, List<Integer> answer) {
        int max = 0;
        input.sort(Collections.reverseOrder());

        for(int i = 0; i < 6; i++) {
            if (input.get(0) >= answer.get(i)) {
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
