package lotto.service;

import java.util.stream.Collectors;
import lotto.config.Rank;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.util.random.NumberGenerator;

public record LottoService(NumberGenerator numberGenerator) {

    public Lottos issueLottos(int issueAmount) {
        LottoMachine lottoMachine = new LottoMachine(numberGenerator);
        return lottoMachine.issue(issueAmount);
    }

    public LottoResult getResult(WinningLotto winningLotto, Lottos lottos) {
        return new LottoResult(lottos.tickets().stream()
                .map(lotto -> Rank.of(winningLotto, lotto))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()))
        );
    }
}
