package lotto.domain;

import lotto.dto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int desiredPurchaseAmount;
    private int numberOfLotto;
    private List<Lotto> lottos = new ArrayList<>();

    public int getDesiredPurchaseAmount() {
        return desiredPurchaseAmount;
    }

    public void setDesiredPurchaseAmount(int desiredPurchaseAmount) {
        this.desiredPurchaseAmount = desiredPurchaseAmount;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public void setNumberOfLotto(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
