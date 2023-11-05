package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class IssueLottery {

    private static List<Integer> issueTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> ticketNumbers = lotto.getNumbers();
        return ticketNumbers;
    }

    public List<List<Integer>> issueTickets(int ticketCount) {
        List<List<Integer>> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lotteryTickets.add(issueTicket());
        }
        return lotteryTickets;
    }
}
