package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.*;
import java.util.*;

public class LottoGameDecisionMachine {
    private List<Lotto> tickets = new ArrayList<>();

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void generateTickets_(int purchaseAmount) {
        int numTickets = purchaseAmount / 1000;
        for (int i = 0; i < numTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
        }
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public Map<Integer, Integer> checkTickets() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto ticket : tickets) {
            int numMatching = countMatchingNumbers(ticket.getNumbers());
            if (numMatching == 6) {
                result.put(6, result.getOrDefault(6, 0) + 1);
                Prize.FIRST_PLACE.plusCount(1);
            }
            if (numMatching == 5 && ticket.getNumbers().contains(bonusNumber)) {
                Prize.SECOND_PLACE.plusCount(1);
            }
            if (numMatching == 5  && !(ticket.getNumbers().contains(bonusNumber))) {
                Prize.THIRD_PLACE.plusCount(1);
            }
            if (numMatching == 4) {
                Prize.FOURTH_PLACE.plusCount(1);
            }
            if (numMatching == 3) {
                Prize.FIFTH_PLACE.plusCount(1);
            }
        }
        return result;
    }

    private int countMatchingNumbers(List<Integer> ticket) {
        int count = 0;
        for (int number : ticket) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
