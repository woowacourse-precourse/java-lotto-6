package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

// TODO: Repository 인터페이스화
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
