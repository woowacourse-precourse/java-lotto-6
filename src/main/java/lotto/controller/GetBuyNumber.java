package lotto.controller;

import lotto.model.GameMoney;

public interface GetBuyNumber {

    GameMoney getBuyNumber();

    GameMoney getValid(String money);
}
