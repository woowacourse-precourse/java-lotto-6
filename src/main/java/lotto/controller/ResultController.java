package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;

public class ResultController {
    public Result create(Lotto winningLotto, Lottos lottos, Bonus bonus) {
        return new Result(winningLotto, lottos, bonus);
    }
}
