package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<Lotto>();
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void addLotto(List<Integer> list) {
        Lotto lotto = new Lotto(list);
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
