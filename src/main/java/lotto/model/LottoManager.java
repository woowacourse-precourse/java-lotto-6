package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;
    private LottoGenerator generator;

    public LottoManager(LottoGenerator generator) {
        lottos = new ArrayList<>();
        this.generator = generator;
    }

    public void generateLottos(int purchaseMoney) {
        int ticketNumber = purchaseMoney / 1000;
        for (int i = 0; i < ticketNumber; i++) {
            Lotto newLotto = generator.createSingleLotto();
            lottos.add(newLotto);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
