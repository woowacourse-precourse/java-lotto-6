package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.RandomValueList;

public class LottoService {
    private Lotto lotto;

    public static LottoService getInstance() {
        return LottoService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoService INSTANCE = new LottoService();
    }

    public List<Integer> getLotto(){
        lotto = new Lotto(RandomValueList.getRandomValue());
        return lotto.getLotto();
    }
}
