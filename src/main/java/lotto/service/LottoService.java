package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.LottoGenerator;

public class LottoService {
    public List<Lotto> lottos;

    public List<Lotto> getLottos(LottoGenerator generator){
        generator.generateLottos();
        return generator.getLottos();
    }
}
