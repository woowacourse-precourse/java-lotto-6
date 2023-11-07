package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {
    public List<Lotto> generateLottoGroup(int createLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < createLottoCount) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        GenerateNumber lottoNumbersGenerator = new GenerateNumber();
        return new Lotto(lottoNumbersGenerator.randomLottoCreate());
    }
}
