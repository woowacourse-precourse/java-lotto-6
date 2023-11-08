package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Constants.*;

public class RandomNumbers {

    private final List<List<Integer>> randomLottoNumbers = new ArrayList<>();

    public RandomNumbers(int lottoPapers) {
        for (int i = 0; i < lottoPapers; i++) {
            randomLottoNumbers.add(setRandomNumbers());
        }
    }

    private List<Integer> setRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,LOTTO_LENGTH);
    }
    public Integer getSizeOfRandomNumbers(){ return randomLottoNumbers.size(); }

    public List<Integer> getEachLottoNumbers(int index) {
        return randomLottoNumbers.get(index);
    }

}
