package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Domain.Lotto;

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
        for (int i=0; i<ticketQuantity; i++){
            lotteryTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        sortLottosAscending(lotteryTickets);
    }
    private void sortLottosAscending(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            lotto.sortLottoNumbersAscending();
        }
    }
}
