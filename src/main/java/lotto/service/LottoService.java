package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.util.Constant;
import lotto.util.RandomValues;

public class LottoService {
    public static LottoService getInstance() {
        return LottoService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoService INSTANCE = new LottoService();
    }

    private Lotto getLotto(){
        return new Lotto(RandomValues.getRandomValues());
    }

    public List<Lotto> getLottoList(int purchaseNumber) {
        return IntStream.range(0, purchaseNumber)
                .mapToObj(i -> getLotto())
                .toList();
    }

    public int getPurchaseNumber(int input) {
        return input/Constant.AMOUNT_ONE_LOTTO;
    }
}
