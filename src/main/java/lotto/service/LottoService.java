package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.RandomNumberUtil;

public class LottoService {
    private Lottos lottos = new Lottos();
    private RandomNumberUtil randomNumberUtil = new RandomNumberUtil();

    public Lottos issueLottos(Buyer buyer) {
        int issueNumber = buyer.getNumberOfLotto();
        while (issueNumber != 0) {
            new Lotto(randomNumberUtil.createSixUniqueRandomNumber(), lottos);
            issueNumber--;
        }
        return lottos;
    }
}
