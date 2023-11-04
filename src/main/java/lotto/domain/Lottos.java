package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> Lottos = new ArrayList<>();

    public void add(Lotto lotto){
        Lottos.add(lotto);
    }
    public int size(){
        return Lottos.size();
    }

}
