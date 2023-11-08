package lotto.validation;

import static lotto.util.Util.inputPrice;
import static lotto.view.ErrorView.*;

public class InputValidation {
    private InputValidation(){}
    public static int validateCost(String cost){
        cost = verifyInteger(cost);
        cost = verifyThousand(cost);
        return Integer.parseInt(cost);
    }

    // 검증 후 아니면 다시 묻기
    public static String verifyInteger(String cost){
        try {
            validateInteger(cost);
        }catch (IllegalArgumentException e){
            errorNotInteger();
            cost = inputPrice();
        }
        return cost;
    }

    // 검증 후 아니면 다시 묻기
    public static String verifyThousand(String cost){
        try{
            validateThousand(cost);
        }catch(IllegalArgumentException e){
            errorNotThousand();
            cost = inputPrice();
            validateCost(cost);
        }
        return cost;
    }

    // 천원단위인지 검증
    public static void validateThousand(String cost){
        int c = Integer.parseInt(cost);
        if (c < 1000 || c % 1000 > 0){
            throw new IllegalArgumentException();
        }
    }

    // 숫자인지 검증
    public static void validateInteger(String cost){
        try{
            Integer.parseInt(cost);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}