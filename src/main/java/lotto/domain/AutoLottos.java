package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottos {
    private List<Lotto> lottos = new ArrayList<>();

    public AutoLottos() {
    }

    public static AutoLottos from() {
        return new AutoLottos();
    }

    public void createAutoLottos(int lottoCount, Generator generator) {
        while (lottoCount-- > 0) {
            lottos.add(getNewLotto(generator));
        }
    }

    private Lotto getNewLotto(Generator generator) {
        return Lotto.createAutoLottoNumbers(generator);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
