package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.ErrorMessage;

public class LottoCheck {

    public List<Integer> winLottoErrorCheck(String winLotto) throws IllegalArgumentException {
        winLottoFormatCheck(winLotto);
        String[] tempWinLottoNumbers = winLotto.split(",");
        winNumberDuplicationCheck(tempWinLottoNumbers);
        winNumberSizeCheck(tempWinLottoNumbers);

        List<Integer> tempLottoNumbers = new ArrayList<>();
        for(String winNumber : tempWinLottoNumbers){
            int checkedNumber = lottoNumberTypeCheck(winNumber);
            winNumberRangeCheck(checkedNumber);
            tempLottoNumbers.add(checkedNumber);
        }
        return tempLottoNumbers;
    }

    public int bonusLottoErrorCheck(String bonusLotto) throws IllegalArgumentException{
        lottoNumberTypeCheck(bonusLotto);
        int bonusLottoNumber = Integer.parseInt(bonusLotto);
        winNumberRangeCheck(bonusLottoNumber);
        return bonusLottoNumber;
    }

    private void winNumberRangeCheck(int checkedNumber) {
        if(checkedNumber < 1 || checkedNumber > 46){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMsg());
        }
    }

    private int lottoNumberTypeCheck(String winNumber) {
        try{
            return Integer.parseInt(winNumber);
        } catch (Exception e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMsg());
        }
    }

    private void winNumberSizeCheck(String[] tempWinLottoNumbers) {
        if(tempWinLottoNumbers.length != 6){
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getMsg());
        }
    }

    private void winNumberDuplicationCheck(String[] tempWinLottoNumbers) {
        if(tempWinLottoNumbers.length != Arrays.stream(tempWinLottoNumbers).distinct().count());{
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR.getMsg());
        }
    }

    private void winLottoFormatCheck(String winLotto) {
        if(!winLotto.contains(",")){
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getMsg());
        }
    }
}
