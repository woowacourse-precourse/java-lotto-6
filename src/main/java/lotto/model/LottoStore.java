package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final IssueMachine issueMachine;

    public LottoStore() {
        this.issueMachine = new IssueMachine();
    }

    public List<Lotto> sell(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(issueMachine.lotto()));
        }
        return lottos;
    }
}
