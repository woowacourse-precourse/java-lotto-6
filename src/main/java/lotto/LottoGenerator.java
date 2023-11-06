package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int ticket) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < ticket) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return new Lotto(lottoNumberGenerator.generateLottoNumbers());
    }
}
