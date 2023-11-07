package lotto.domain.service;

import lotto.domain.model.LottosResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;

public interface User {
    Lottos buyLottos(int ticketAmount) ;
    LottosResult matchUp(Lotto answer, int bonusNumber) ;
    User newInstance(Money givenMoney);
}