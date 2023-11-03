package lotto;

import java.util.List;

public class LottoRepository {
    private List<Lotto> lottos;
    private final Lotto winningLotto;
    public LottoRepository(Lotto winningLotto){
        this.winningLotto=winningLotto;
    }
    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }
}
