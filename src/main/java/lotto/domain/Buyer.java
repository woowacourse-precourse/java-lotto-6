package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.Validation;

public class Buyer {
    private final int amount;
    private final List<Lotto> lottos = new ArrayList<>();

    public Buyer(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void validateAmount(int amount) {
        Validation.validateDigit(amount);
//        Validation.validateIsBlank(amount);
//        Validation.validateStringToInteger(amount);
    }


}
