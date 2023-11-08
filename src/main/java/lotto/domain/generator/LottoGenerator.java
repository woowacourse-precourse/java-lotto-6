package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
    }
}
