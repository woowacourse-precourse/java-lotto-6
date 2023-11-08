package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class PurchaseRepository {
    private static final PurchaseRepository instance = new PurchaseRepository();
    private List<Lotto> lottos = new ArrayList<>();

    public static PurchaseRepository getInstance() {
        return instance;
    }

    public void recordPurchase(Lotto lotto) {
        lottos.add(lotto);
    }

    public Integer size() {
        return lottos.size();
    }

    public List<Lotto> findLottos() {
        return new ArrayList<>(lottos);
    }

}
