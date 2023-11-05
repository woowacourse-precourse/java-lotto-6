package model;

import java.util.List;

public class Lottos {
    //로또들을 관리하는 클래스
    private List<Lotto> lottos;

    public void initLottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
