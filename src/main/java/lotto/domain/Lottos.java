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
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos){
            sb.append(lotto.toStringForDisplay()).append("\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return lottos.size();
    }
}
