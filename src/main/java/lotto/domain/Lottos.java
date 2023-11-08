package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoGenerator;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int numberOfLotto) {
        this.lottos = createLottos(numberOfLotto);
    }

    private List<Lotto> createLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(LottoGenerator.createLotto()));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
