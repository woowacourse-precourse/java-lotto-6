package lotto.domain.user;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.generator.NumberGenerator;

public class UserLotto {
    private Lotto lotto;

    private LottoCount lottoCount;

    private List<Lotto> lottos = new ArrayList<>();

    public UserLotto(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void create(NumberGenerator numberGenerator) {
        while (lottoCount.isContinue()) {
            lotto = new Lotto(numberGenerator.create());
            lottos.add(lotto);
            lottoCount.minusCount();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
