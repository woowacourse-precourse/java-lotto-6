package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }


}
