package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoGenerator generator;
    private final List<Lotto> purchasedLottos;
    public LottoMachine(LottoGenerator generator) {
        this.generator = generator;
        this.purchasedLottos = new ArrayList<>();
    }
    public void purchaseLottos(int numberOfLottos) {
        for (int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = generator.generate();
            purchasedLottos.add(lotto);
        }
    }
}
