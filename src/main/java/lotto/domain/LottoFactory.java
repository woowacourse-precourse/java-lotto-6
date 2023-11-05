package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumbersGenerator;

public class LottoFactory {
    public static List<Lotto> createLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>(lottoQuantity);
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        return new Lotto(LottoNumbersGenerator.generate());
    }
}
