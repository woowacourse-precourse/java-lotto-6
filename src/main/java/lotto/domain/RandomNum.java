package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNum {
    public List<List<Integer>> buyLotto (int inputPrice){
        List<List<Integer>>randomLottoNumbers = new ArrayList<>();
        for(int i = 0; i < inputPrice/1000; i++){
            randomLottoNumbers.add(getRandomLottoNumbers());
        }
        return randomLottoNumbers;
    }

    public List<Integer> getRandomLottoNumbers(){
        return (List<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
