package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<Lotto> lottoTickets;

    public LottoTickets(){
        lottoTickets = new ArrayList<>();
    }

    public void setTicket(Lotto lotto){
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

}
