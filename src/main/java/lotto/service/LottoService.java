package lotto.service;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.model.RandomLottos;
import lotto.model.WinningLotto;
import lotto.repository.ResultRepository;

public class LottoService {

    private final ResultRepository resultRepository;

    public LottoService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void calculate(RandomLottos randomLottos, WinningLotto winningLotto) {
        resultRepository.init();
        randomLottos.getRanks(winningLotto)
                .forEach(o -> o.ifPresent(resultRepository::add));
    }

    public String getResult() {
        return resultRepository.toString();
    }

    public BigDecimal getPercent(Money money) {
        return resultRepository.calculatePercent(money);
    }
}
