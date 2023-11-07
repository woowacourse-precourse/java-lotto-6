package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoNumberGenerator;


public class LottoPurchaseManager {

    private int count;
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public LottoPurchaseManager(int purchaseAccount) {
        this.count = purchaseAccount / 1000;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getCount() {
        return count;
    }

    public void generateLottos() {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
    }
}
