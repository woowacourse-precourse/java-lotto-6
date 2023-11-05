package lotto;

import java.util.List;

public class Money {

    public String amount;

    public Money(String amount) {
        validateFormat(amount);
        this.amount = amount;
    }

    private void validateFormat(String amount) {
        if (!amount.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
