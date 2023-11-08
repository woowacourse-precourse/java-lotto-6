package lotto.Model;

import lotto.Controller.ErrorMessage;

public class Cache {
    private Integer cache;

    public Cache(Integer balance){
        validateCache(balance);
        cache = balance;
    }
    public Integer getAmount(){
        return cache;
    }

    public void deposit(Integer money){
        cache+=money;
    }
    public static void validateCache(Integer insertData){
        if(isNegative(insertData)){
            throw new IllegalArgumentException(ErrorMessage.CASH_NOT_POSITIVE.getMessage());
        }
    }
    private static boolean isNegative(Integer insertData){
        return insertData < 0;
    }
}
