package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.entity.Lotto;
import lotto.domain.lotto.entity.Lottos;
import lotto.domain.lotto.generator.LottoGenerator;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    //todo money 래핑 하기
    public Lottos purchaseLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        if (money % 1_000 != 0) {
            //todo 다른데로 분리하기
            throw new IllegalArgumentException();
        }
        while (money > 0) {
            lottos.add(generateLotto());
            money -= 1_000;
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        return lottoGenerator.generate();
    }
}
