package lotto;

import java.util.List;

public class LottoRepository {
    private List<Lotto> lottos;
    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }
}
