package lotto.LottoPlayer.entity;

import lotto.Lotto.entity.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPlayer {
    int purchase_amount;
    List<Lotto> issued_lotto = new ArrayList<>();

    public LottoPlayer() {
        this.purchase_amount = 0;
    }


    public LottoPlayer(int purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    public void setIssuedLotto(List<Lotto> issued_lotto) {
        this.issued_lotto = issued_lotto;
    }

    public List<Lotto> getIssuedLotto() {
        return issued_lotto;
    }

    public void setPurchaseAmount(int purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    public int getPurchaseAmount() {
        return purchase_amount;
    }
}
