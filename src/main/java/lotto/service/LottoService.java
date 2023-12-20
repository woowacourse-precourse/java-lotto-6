package lotto.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lotto.model.Money;
import lotto.model.RandomLottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.repository.ResultRepository;

public class LottoService {

    private final ResultRepository resultRepository;

    public LottoService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void calculate(RandomLottos randomLottos, WinningLotto winningLotto) {
        resultRepository.init();
        List<Optional<Rank>> ranks = randomLottos.getRanks(winningLotto);
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
