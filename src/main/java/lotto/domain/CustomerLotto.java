package lotto.domain;

import java.util.List;

public class CustomerLotto {
    private Lotto lottos;
    private int bonusNum;
    public CustomerLotto(Lotto lottos,int bonusNum){
        this.lottos = lottos;
        this.bonusNum = bonusNum;
    }

    public Lotto getLottos() {
        return lottos;
    }

    public void setLottos(Lotto lottos) {
        this.lottos = lottos;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }
}
