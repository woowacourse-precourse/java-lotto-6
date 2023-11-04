package lotto;


import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos=lottos;
    }

    public long getLottoAmount(){
        return lottos.size();
    }

    public List<Lotto> getLottoTickets(){
        return Collections.unmodifiableList(lottos);
    }

}
