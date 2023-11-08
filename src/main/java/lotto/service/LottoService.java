package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.utils.LottoGenerator;

public class LottoService {

    public Lottos createLottos(Amount amount) {
        int lottoCount = amount.getLottoCount();
        List<Lotto> lottos = IntStream.range(0, lottoCount)
            .mapToObj(i -> new Lotto(LottoGenerator.generate()))
            .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public Result createResult(Lottos lottos, WinningLotto winningLotto) {
        return lottos.getResult(winningLotto);
    }
}
