package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private List<List<Integer>> numberTickets;
    private List<Integer> numbers;
    public void makeNumberTicket(Integer totalTicketNumber){
        while (totalTicketNumber > numberTickets.size()){
            makeNumber();
            numberTickets.add(makeNumber());
        }
    }
    private List<Integer> makeNumber(){
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
