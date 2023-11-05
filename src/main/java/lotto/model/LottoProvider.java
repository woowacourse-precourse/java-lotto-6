package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoProvider {

    private final LottoNumberCreator lottoNumberCreator;

    public LottoProvider() {
        lottoNumberCreator = new LottoNumberCreator();
    }


    public List<Lotto> lottoGenerate(int each) {
        List<Lotto> lottos = new ArrayList<>(each);
        return lottos;
    }
}
