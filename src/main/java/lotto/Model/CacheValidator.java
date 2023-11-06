package lotto.Model;

public class CacheValidator {


    public static void exceptCache(Integer insertData){
        if(validateThousand(insertData)){
            throw new IllegalArgumentException("금액은 1000원 단위로 입력되어야 합니다.");
        }
    }
    private static boolean validateThousand(Integer insertData){
        return insertData%1000 != 0;
    }
}
