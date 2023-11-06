package lotto.domain;

import static lotto.settings.ErrorMessage.*;
import static lotto.settings.LottoSettings.*;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount from(int amount){
        validateUnits(amount);
        return new PurchaseAmount(amount);
    }

    private static void validateUnits(int amount) {
        if(amount % PER_lOTTO_PRICE.getNumber() !=0){
            throw new IllegalArgumentException(INVALID_UNIT_FORMAT.getMessage());
        }
    }

    public int calculateCount(){
        return amount/ PER_lOTTO_PRICE.getNumber();
    }
}

