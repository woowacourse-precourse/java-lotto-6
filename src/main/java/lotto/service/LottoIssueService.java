package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.dto.LottosDTO;

public class LottoIssueService {
    private final LottoMachine lottoMachine = new LottoMachine();

    public LottoIssueService() {
    }

    public LottosDTO sendBoughtLotto(Money money) {
        Lottos lottos = lottoMachine.issueLottos(money);

        return new LottosDTO(lottos);
    }
}
