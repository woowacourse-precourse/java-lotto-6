package lotto.model;

import java.util.List;

public class Customer {
    private List<Lotto> lottos;

    public void buyLotto(Money money){
        this.lottos = LottoGenerator.issueLottoTickets(money);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public String getLottosString(){
        StringBuilder sb = new StringBuilder();
        lottos.forEach((lotto)->sb.append(lotto.toString()).append("\n"));
        return sb.toString();
    }
}
