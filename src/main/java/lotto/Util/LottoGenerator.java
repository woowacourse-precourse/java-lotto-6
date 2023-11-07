package lotto.Util;

import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int createLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < createLottoCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        LottoNumberGenerator lottoNumbersGenerator = new LottoNumberGenerator();
        return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
    }


}
