package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public String getLottosForDisplay(){
        StringBuilder stackLotto = new StringBuilder();
        for(Lotto lotto : lottos){
            stackLotto.append(lotto.toStringForDisplay()).append("\n");
        }
        return stackLotto.toString();
    }

    public int getSize(){
        return lottos.size();
    }
}
