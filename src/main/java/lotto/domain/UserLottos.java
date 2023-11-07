package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserLottos {
    private int buyingPrice = 0;
    private int winningPrice = 0;
    private int ammount;
    private List<UserLotto> lottos = new ArrayList<>();

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
        this.ammount = Integer.parseInt(ammount) / 1000;
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
