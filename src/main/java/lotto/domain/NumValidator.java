package lotto.domain;

import java.util.List;

import static lotto.view.Constants.*;
import static lotto.view.Message.*;

public class NumValidator {

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
