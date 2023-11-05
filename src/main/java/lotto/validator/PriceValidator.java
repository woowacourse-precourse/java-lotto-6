package lotto.validator;

public class PriceValidator extends Validator{
    private final static int PURCHASE_COST = 1000;
    private final static int MAX_PURCHASE_COST = 100000;

    public static boolean validateCost(int cost){
        return validateNumberRange(cost, PURCHASE_COST, MAX_PURCHASE_COST);
    }
    public static boolean validateThousand(int cost){
        if(cost%PURCHASE_COST!=0){
            return false;
        }
        return true;
    }
}
