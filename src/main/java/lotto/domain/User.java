package lotto.domain;

import java.util.List;

public class User {

    LottoMachine lottoMachine = new LottoMachine();

    private List<Lotto> lottos;
    private int money;

    public User(String money) {
        this.money = changeInteger(money);
        lottos = lottoMachine.drawLottoRandomNumber(this.money);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }

    private int changeInteger(String money) {
        return Integer.parseInt(money);
    }
}
