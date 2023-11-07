package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoNumberGenerator;


public class LottoPurchaseManager {

    private final int count;
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public LottoPurchaseManager(int purchaseAmount) {
        this.count = purchaseAmount / 1000;
    }

    public void generateLottos() {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getCount() {
        return count;
    }

}
