package lotto.Domain;

import lotto.Domain.*;
import java.util.*;

public class LottoGameDecisionMachine {
    private List<Lotto> tickets = new ArrayList<>();
    private final static ArrayList<Prize> PRIZE_TYPE = new ArrayList<>(Arrays.asList(
            Prize.FIRST_PLACE,
            Prize.SECOND_PLACE,
            Prize.THIRD_PLACE,
            Prize.FOURTH_PLACE,
            Prize.FIFTH_PLACE));

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void generateTickets(int purchaseAmount) {
        int numTickets = purchaseAmount / 1000;
        Random random = new Random();

        for (int i = 0; i < numTickets; i++) {
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 6) {
                int number = random.nextInt(45) + 1;
                if (!numbers.contains(number)) {
                    numbers.add(number);
                }
            }
            Collections.sort(numbers);
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
                //System.out.println(result.get(6));
            }
            if (numMatching == 5 && ticket.getNumbers().contains(bonusNumber)) {
                Prize.SECOND_PLACE.plusCount(1);
                //result.put(7, result.getOrDefault(7, 0) + 1);
            }
            if (numMatching == 5  && !(ticket.getNumbers().contains(bonusNumber))) {
                Prize.THIRD_PLACE.plusCount(1);
                //result.put(5, result.getOrDefault(5, 0) + 1);
            }
            if (numMatching == 4) {
                //result.put(4, result.getOrDefault(4, 0) + 1);
                Prize.FOURTH_PLACE.plusCount(1);
            }
            if (numMatching == 3) {
                //result.put(3, result.getOrDefault(3, 0) + 1);
                Prize.FIFTH_PLACE.plusCount(1);
            } //else {
                //result.put(numMatching, result.getOrDefault(numMatching, 0) + 1);
            //}
        }
        return result;
    }
/*
    public int countMatchinTickets(){

    }
*/
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
