package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Domain.Lotto;
import lotto.Validator;

import java.util.List;
import java.util.ArrayList;

public class DrawTicketController extends Controller {
    int ticketQuantity;
    List<Lotto> lotteryTickets;

    public DrawTicketController(int quantity){
        this.ticketQuantity = quantity;
    }
    @Override
    public void run() {
        lotteryTickets = new ArrayList<>(ticketQuantity);
        Lotto newLotto;
        Validator dupeChecker = new Validator();
        for (int i=0; i<ticketQuantity; i++){
            newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotteryTickets.add(newLotto);
        }
    }
}
