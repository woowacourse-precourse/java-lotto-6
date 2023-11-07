package lotto.domain;

public class Buyer {
    private Amount amount;

    public Buyer(String inputString) {
        Amount amount = new Amount(inputString);
    }


}
