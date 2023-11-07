package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos{

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(Lotto... collect) {
    }

    public int getLottoCount(){
        return lottos.size();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
