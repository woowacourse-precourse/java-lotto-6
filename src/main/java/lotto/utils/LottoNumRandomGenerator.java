package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumRandomGenerator {

    private static final int MIN=1;
    private static final int MAX=45;
    private static final int AMOUNT=6;

    public List<Integer> setRandomNum(){
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, AMOUNT);
    }

    public void sortRandomNum(List<Integer> randomNum){
        Collections.sort(randomNum);
    }
}
