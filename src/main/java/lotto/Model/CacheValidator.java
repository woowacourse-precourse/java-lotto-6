package lotto.Model;

import lotto.Controller.ErrorMessage;

public class CacheValidator {


    public static void validateCache(Integer insertData){
        if(isNonPositive(insertData)){
            throw new IllegalArgumentException(ErrorMessage.CASH_NOT_POSITIVE.getMessage());
        }

        if(isThousand(insertData)){
            throw new IllegalArgumentException(ErrorMessage.CASH_NOT_THOUSAND.getMessage());
        }

    }
    private static boolean isThousand(Integer insertData){
        return insertData%1000 != 0;
    }

    private static boolean isNonPositive(Integer insertData){
        return insertData <= 0;
    }
}
