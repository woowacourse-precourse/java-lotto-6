package lotto.domain;

import java.util.List;

public class NumValidator {

    private static final int NUM_OF_LOTTO =6;
    private static final int MIN_NUM =1;
    private static final int MAX_NUM =45;

    private static final String RANGE_ERROR="[ERROR] 옳지 않은 범위의 숫자를 입력하셨습니다.";
    private static final String TYPE_ERROR ="[ERROR] 숫자가 아닌 값을 입력하셨습니다.";
    private static final String NUMBER_OF_INPUT_CNT_ERROR ="[ERROR] 로또 숫자만큼 다시 입력해주세요!";

    private static final String NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 "+NUM_OF_LOTTO+"개 입력 가능합니다.";
    private static final String OVERLAP_NUM_ERROR="[ERROR] 중복된 숫자가 존재합니다.";

    public static int checkNumber(String num){
        try{
            return Integer.parseInt(num);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    public static int checkRange(int num){
        if(num<=0 || num>MAX_NUM){
            throw new IllegalArgumentException(RANGE_ERROR);
        }
        return num;
    }

    public static void checkCntNumber(List<Integer> winningNumbers){
        if(winningNumbers.size()!= NUM_OF_LOTTO){
            throw new IllegalArgumentException(NUMBER_OF_INPUT_CNT_ERROR);
        }
    }



}
