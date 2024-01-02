package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.repository.Result;

public class LottoService {

    private final Result result;
    private final LottoMachine lottoMachine;
    private List<Lotto> randomLotto;

    public LottoService(Result result, LottoMachine lottoMachine) {
        this.result = result;
        this.lottoMachine = lottoMachine;
    }

    public void run(Money money, WinningLotto winningLotto) {
        result.init();
        randomLotto = lottoMachine.buyLotto(money);
        Rank.check(randomLotto, winningLotto)
                .forEach(r -> r.ifPresent(result::add));
    }

    public List<Lotto> getRandomLotto() {
        return randomLotto;
    }

    public Result getResult() {
        return result;
    }
}
