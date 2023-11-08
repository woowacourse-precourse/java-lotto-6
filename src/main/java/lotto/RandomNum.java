package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class RandomNum {
    public RandomNum() {
    }
    private static List<Integer> lottoNum;

    public static List<Integer> setRandomNumbers() {
        lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumList = new ArrayList<>(lottoNum);
        Collections.sort(lottoNumList); //정렬
        return lottoNumList;
    }
}
