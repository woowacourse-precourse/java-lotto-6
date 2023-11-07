package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {
    int payed;
    List<Lotto> lottos;

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

}
