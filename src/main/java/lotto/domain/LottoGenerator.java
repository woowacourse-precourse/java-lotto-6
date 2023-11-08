package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int createLottoCount) {
        List<Lotto> lottoGroup = new ArrayList<>();

        while (lottoGroup.size() < createLottoCount) {
            lottoGroup.add(generateLotto());
        }

        return lottoGroup;
    }

    public Lotto generateLotto() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
    }
}
