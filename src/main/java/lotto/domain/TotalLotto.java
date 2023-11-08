package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalLotto {
    private final List<Lotto> totalLotto;

    public TotalLotto() {
        this.totalLotto = new ArrayList<>();
    }

    public void generateTotalLotto(Lotto lotto) {
        totalLotto.add(lotto);
    }

    public List<Lotto> getTotalLotto() {
        return new ArrayList<>(totalLotto);
    }
}
