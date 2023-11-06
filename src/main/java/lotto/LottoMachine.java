package lotto;

import java.util.List;

public class LottoMachine {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> createLottos(int lottoCount) {
        return lottoGenerator.createLottos(lottoCount);
    }
}
