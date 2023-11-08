package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.validation.Validation;

public class Buyer {
    private final int amount;
    private final List<Lotto> lottos = new ArrayList<>();
    private final HashMap<Rank, Integer> result = new HashMap<>();
    private double returnRate;

    public Buyer(int amount) {
        validateAmount(amount);
        this.amount = amount;
        initResult();
    }

    public int getAmount() {
        return this.amount;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void setLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public HashMap<Rank, Integer> getResult() {
        return this.result;
    }

    public double getReturnRate() {
        return this.returnRate;
    }

    public void setReturnRate(double returnRate) {
        this.returnRate = returnRate;
    }

    private void validateAmount(int amount) {
        Validation.validateDigit(amount);
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }


}
