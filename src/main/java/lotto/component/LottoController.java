package lotto.component;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.Result;
import lotto.domain.winning.Winning;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public static LottoController of(LottoService lottoService) {
        return new LottoController(lottoService);
    }

    private LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public Result run(List<Lotto> lottos, Winning winning) {
        return lottoService.getResult(winning, lottos);
    }
}
