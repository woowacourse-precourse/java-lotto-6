package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<Lotto> lottos;

    public LottoTickets(){
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }
}
