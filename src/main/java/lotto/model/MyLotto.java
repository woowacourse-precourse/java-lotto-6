package lotto.model;

import java.util.List;

public class MyLotto {
    private final List<Lotto> lottos;

    public MyLotto(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
