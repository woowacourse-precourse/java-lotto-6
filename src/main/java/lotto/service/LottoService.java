package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;

public class LottoService {

    private final LottoNumberGenerator lottoGenerator;

    private LottoService() {
        lottoGenerator = new LottoNumberGenerator();
    }

    public static LottoService startGame() {
        return new LottoService();
    }

    public PurchasedLotto createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = lottoGenerator.generateLotto();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return new PurchasedLotto(lottos);
    }
}
