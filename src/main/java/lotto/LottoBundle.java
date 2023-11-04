package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private List<Lotto> lottoBundle = new ArrayList<>();

    public void addLotto(List<Integer> randomNumber) {
        lottoBundle.add(new Lotto(randomNumber));
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
