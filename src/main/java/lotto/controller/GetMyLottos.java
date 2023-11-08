package lotto.controller;

import lotto.Lotto;
import lotto.model.GameMoney;

import java.util.ArrayList;
import java.util.List;

public interface GetMyLottos {

    public List<Lotto> getMyLottos(GameMoney gameMoney);

}
