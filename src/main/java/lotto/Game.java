package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private List<Lotto> numberTickets;
    public void makeNumberTicket(Integer totalTicketNumber){
        while (totalTicketNumber > numberTickets.size()){
            makeNumber();
            numberTickets.add(makeNumber());
        }
    }
    private Lotto makeNumber(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }
}
