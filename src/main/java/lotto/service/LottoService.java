package lotto.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.ResultRepository;

public class LottoService {

    private final ResultRepository resultRepository;

    public LottoService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void calculate(Lottos lottos, WinningLotto winningLotto) {
        resultRepository.init();
        List<Optional<Rank>> ranks = lottos.getRanks(winningLotto);
        ranks.forEach(o -> o.ifPresent(
                rank -> {
                    int count = resultRepository.get(rank);
                    resultRepository.add(rank, count);
                }
        ));
    }

    public String getResult() {
        return resultRepository.toString();
    }

    public BigDecimal getPercent(Money money) {
        return resultRepository.calculatePercent(money);
    }
}
