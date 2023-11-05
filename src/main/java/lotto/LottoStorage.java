package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStorage {
    private final List<Lotto> lotteries;

    public LottoStorage() {
        this.lotteries = new ArrayList<>();
    }

    public Lotto saveLotto(Lotto lotto) {
        lotteries.add(lotto);
        return lotto;
    }

    public List<Lotto> findAllLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
