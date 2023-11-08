package lotto.controller;

import lotto.model.GameMoney;

public interface GetBuyNumber {

    public GameMoney getBuyNumber();

    public GameMoney getValid(String money);
}
