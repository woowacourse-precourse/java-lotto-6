package lotto.Model;

public class CacheValidator {


    public static void exceptCache(Integer insertData){
        if(validateZero(insertData)){
            throw new IllegalArgumentException("[ERROR] 입력 금액은 0원을 초과해야 합니다.");
        }

        if(validateThousand(insertData)){
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위로 입력되어야 합니다.");
        }

    }
    private static boolean validateThousand(Integer insertData){
        return insertData%1000 != 0;
    }

    private static boolean validateZero(Integer insertData){
        return insertData <= 0;
    }
}
