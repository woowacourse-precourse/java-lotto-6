package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.PurchasePrice;

public class LottoTicket {
    private final List<Lotto> lottoTicket;
    private final LottoMachine lottoMachine = new RandomLottoMachine();

    public LottoTicket(PurchasePrice price){
        this.lottoTicket = createLottoTicket(price);
    }

    public int getLottoTicketSize(){
        return lottoTicket.size();
    }

    private List<Lotto> createLottoTicket(PurchasePrice price){
        List<Lotto> tickets = new ArrayList<>();
        int lottoQuantity = price.getLottoQuantity();
        while (lottoQuantity-- > 0){
            Lotto newLotto = createLotto();
            tickets.add(newLotto);
        }
        return tickets;
    }

    private Lotto createLotto(){
        return lottoMachine.generateLotto();
    }



}
