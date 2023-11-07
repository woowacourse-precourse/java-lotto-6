package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.ParseString;

public class UserLottos {
    ParseString parse = new ParseString();
    List<UserLotto> lottos = new ArrayList<>();
    private int buyingPrice = 0;
    private int winningPrice = 0;
    private int ammount;

    public void setLottos() {
        UserLotto lotto = new UserLotto();
        lotto.setLotto();
        lottos.add(lotto);
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice += buyingPrice;
    }

    public void setWinningPrice(int winningPrice) {
        this.winningPrice += winningPrice;
    }

    public void setAmmount(String ammount) {
        this.ammount = parse.parseToInt(ammount)/1000;
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getAmmount() {
        return ammount;
    }
}
