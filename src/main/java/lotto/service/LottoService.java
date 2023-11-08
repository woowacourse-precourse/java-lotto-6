package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.Result;
import lotto.domain.winning.Winning;

public class LottoService {

    public static LottoService of() {
        return new LottoService();
    }

    private LottoService() {
    }

    public Result getResult(Winning winning, List<Lotto> lottos) {
        Result result = Result.of();
        result.aggregate(winning, lottos);
        result.calculate(lottos.size());

        return result;
    }
}
