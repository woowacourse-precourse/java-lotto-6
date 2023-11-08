package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class TotalLotto {
    private List<Lotto> totalLotto = new ArrayList<>();

    public void generateTotalLotto(Lotto lotto) {
        totalLotto.add(lotto);
    }

}
