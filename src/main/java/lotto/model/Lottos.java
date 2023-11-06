package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public void addLotto (Lotto lotto){
        lottos=new ArrayList<>();
        lottos.add(lotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
