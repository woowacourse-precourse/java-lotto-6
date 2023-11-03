package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(List<Integer> lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers));
    }

}
