package lotto.domain.user;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.generator.NumberGenerator;

public class UserLotto {
    private final LottoCount lottoCount;

    private final List<Lotto> lottos = new ArrayList<>();

    public UserLotto(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void create(NumberGenerator numberGenerator) {
        while (lottoCount.isContinue()) {
            Lotto lotto = new Lotto(numberGenerator.create());
            lottos.add(lotto);
            lottoCount.minusCount();
        }
    }

    public Lotto indexOf(int index) {
        return lottos.get(index);
    }

    public int size() {
        return lottos.size();
    }
}
