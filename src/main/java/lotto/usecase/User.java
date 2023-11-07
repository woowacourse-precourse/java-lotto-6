package lotto.usecase;

import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.LottosResult;

public interface User {
    Lottos buyLottos(int ticketAmount) ;
    LottosResult matchUp(Lotto answer, int bonusNumber) ;
    User newInstance(Money givenMoney);
}