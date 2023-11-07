package lotto.domain;

import lotto.util.Constants;
import lotto.util.Util;

import java.util.Collections;
import java.util.List;


public class LottoNumValidator {
    private final String lottoInput;
    public static List<Integer> lottoNums = null;
    public LottoNumValidator(String inputLottoNum) {
        lottoInput = inputLottoNum;
        lottoNums = Util.toList(inputLottoNum);
        Collections.sort(lottoNums);
        numValidators();
    }
    public void numValidators() {
        isRightNums();
        isRightRange();
        isRightSize();
        isNotDuplicate();
    }
    public void isRightNums(){
        if (!Constants.numsStringPattern.matcher(lottoInput).matches()) {
            throw new IllegalArgumentException(Constants.NUM_WRONG_ERROR);
        }
    }
    public void isRightRange(){
        if(lottoNums.stream().anyMatch(num->num<1||num>45)){
            throw new IllegalArgumentException(Constants.NUM_SIZE_ERROR);
        }
    }
    public void isNotDuplicate(){
        if(lottoNums.size()!=lottoNums.stream().distinct().count()){
            throw new IllegalArgumentException(Constants.NUM_DUPLICATE_EORROR);
        }
    }
    public void isRightSize(){
        if(lottoNums.size()!=6){
            throw new IllegalArgumentException(Constants.NUM_COUNT_ERROR);
        }
    }
}
