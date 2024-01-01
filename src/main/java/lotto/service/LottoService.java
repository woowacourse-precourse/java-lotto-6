package lotto.service;

import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.repository.Result;

public class LottoService {

    private final Result result;

    public LottoService(Result result) {
        this.result = result;
    }

    public void run(Lottos Lottos, WinningLotto winningLotto) {
        result.init();
        Lottos.check(winningLotto).forEach(o -> o.ifPresent(result::add));
    }

    public Result getResult() {
        return result;
    }
}
