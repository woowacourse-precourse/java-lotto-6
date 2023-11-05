package lotto.player;

import lotto.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.MessageConstant.BUYMESSAGE;
import static lotto.constants.NumConstant.PRICE;

public class Wallet {
    private List<Lotto> lottos = new ArrayList<>();
    private int buyMoney;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBuyMoney() {
        return buyMoney;
    }
}
