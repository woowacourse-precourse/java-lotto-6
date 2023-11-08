package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottos(int lottoSize) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoSize) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return new Lotto(lottoNumberGenerator.generateLottoNumber());
    }
}
