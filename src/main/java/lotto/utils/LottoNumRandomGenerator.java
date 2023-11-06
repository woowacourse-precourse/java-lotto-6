package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumRandomGenerator {

    private static final int MIN=1;
    private static final int MAX=45;
    private static final int AMOUNT=6;

    public List<Integer> setRandomNum(){
        List<Integer> result=sortRandomNum(Randoms.pickUniqueNumbersInRange(MIN, MAX, AMOUNT));
        return result;
    }

    private List<Integer> sortRandomNum(List<Integer> randomNum){
        Collections.sort(randomNum);
        return randomNum;
    }
}
