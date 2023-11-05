package lotto.model;

import java.util.List;

public class Customer {
    private List<Lotto> lottos;

    public void buyLotto(Money money){
        this.lottos = LottoGenerator.issueLottoTickets(money);
    }
}
