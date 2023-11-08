package lotto;

public class Validation {
    public boolean isPaymentDivided(int payment){
        boolean isValid = (payment % 1000) != 0;
        return isValid;
    }
}
