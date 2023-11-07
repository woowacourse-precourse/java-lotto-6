package lotto.model.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Budget;

public class LottoTicket {
    private final List<Lotto> lottoTicket;
    private final LottoMachine lottoMachine = new RandomLottoMachine();

    public LottoTicket(Budget price) {
        this.lottoTicket = createLottoTicket(price);
    }

    public int getLottoTicketSize() {
        return lottoTicket.size();
    }

    private List<Lotto> createLottoTicket(Budget price) {
        List<Lotto> tickets = new ArrayList<>();
        int lottoQuantity = price.getLottoQuantity();
        while (lottoQuantity-- > 0) {
            Lotto newLotto = createLotto();
            tickets.add(newLotto);
        }
        return tickets;
    }

    private Lotto createLotto() {
        return lottoMachine.generateLotto();
    }

    public List<Lotto> getLottoTicket(){
        return Collections.unmodifiableList(lottoTicket);
    }

}
