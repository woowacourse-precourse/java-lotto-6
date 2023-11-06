package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private static LottoBundle instance;
    private List<Lotto> lottoBundle = new ArrayList<>();

    private LottoBundle() {}

    public static LottoBundle getInstance() {
        if (instance == null) {
            instance = new LottoBundle();
        }
        return instance;
    }

    public void addLotto(List<Integer> randomNumber) {
        lottoBundle.add(new Lotto(randomNumber));
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
