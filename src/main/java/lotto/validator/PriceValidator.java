package lotto.validator;

public class PriceValidator extends Validator{
    private final static int MIN_PURCHASE_COST = 1000;
    private final static int MAX_PURCHASE_COST = 100000;

    public static boolean validateCost(int cost){
        return validateNumberRange(cost, MIN_PURCHASE_COST, MAX_PURCHASE_COST);
    }
}
