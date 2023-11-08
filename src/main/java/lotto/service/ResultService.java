package lotto.service;

import java.util.Objects;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class ResultService {
    public Result generate(Lottos lottos, WinningLotto winningLotto) {
        Result result = new Result();

        lottos.getLottoTickets().stream()
                .map(winningLotto::getRank)
                .filter(Objects::nonNull)
                .forEach(result::addRank);

        return result;
    }
}
