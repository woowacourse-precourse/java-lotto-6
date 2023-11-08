package lotto.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int createLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < createLottoCount) {
            lottos.add(genrateLotto());
        }

        return lottos;
    }

    public Lotto genrateLotto() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
    }
}
