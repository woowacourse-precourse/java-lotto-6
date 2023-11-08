package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNum {
    public List<List<Integer>> buyLotto (int inputPrice){
        List<List<Integer>>randomLottoNumbers = new ArrayList<>();
        for(int i = 0; i < inputPrice/1000; i++){
            List<Integer> randomNumber = getRandomLottoNumbers();
            sortNumber(randomNumber);
            randomLottoNumbers.add(randomNumber);
        }
        return randomLottoNumbers;
    }

    public List<Integer> sortNumber (List<Integer> randomNumber){
        try{
            Collections.sort(randomNumber);
            return randomNumber;
        }catch(UnsupportedOperationException e){
            return randomNumber;
        }

    }

    private List<Integer> getRandomLottoNumbers(){
        return (List<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
