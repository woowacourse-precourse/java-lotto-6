package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static Lotto generateLotto() {
        return Lotto.from(LottoNumbersGenerator.generateLottoNumbers());
    }
}
