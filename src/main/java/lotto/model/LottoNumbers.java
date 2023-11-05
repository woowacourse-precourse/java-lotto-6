package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionMessage;

public class LottoNumbers {

    public LottoNumbers() {
    }

    private static List<Integer> lottoNumbers;

    public static List<Integer> setRandomNumbers() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumberList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    public static List<Integer> setPrizeNumbers(String lottoPrizeNum) {
        String[] num = lottoPrizeNum.split(",");
        try{
            lottoNumbers = new ArrayList<>();
            for (String s : num) {
                lottoNumbers.add(Integer.parseInt(s));
            }
            return lottoNumbers;
        } catch (IllegalArgumentException e){
            ExceptionMessage.wrongLottoException();
            lottoNumbers = new ArrayList<>();
            for(int i = 0 ; i < num.length ; i++){
                lottoNumbers.add(i,0);
            }
            return lottoNumbers;
        }
    }

    public boolean validateSize(){
        if(lottoNumbers.size() !=6){
            ExceptionMessage.wrongLottoSizeException();
            return false;
        }
        return true;
    }

    public boolean validateRange() {
        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                ExceptionMessage.wrongLottoRangeException();
                return false;
            }
        }
        return true;
    }

    public boolean validateDuplicate() {
        Set<Integer> numSet = new HashSet<>(lottoNumbers);
        if (numSet.size() != lottoNumbers.size()) {
            ExceptionMessage.wrongLottoDuplicateException();
            //throw new IllegalArgumentException();
            return false;
        }
        return true;
    }
}
