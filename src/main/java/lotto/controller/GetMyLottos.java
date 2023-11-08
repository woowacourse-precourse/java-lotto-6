package lotto.controller;

import lotto.Lotto;
import lotto.model.GameMoney;

import java.util.List;

public interface GetMyLottos {

    List<Lotto> getMyLottos(GameMoney gameMoney);

}
