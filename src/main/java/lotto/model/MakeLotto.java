package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLotto {
    public static List<List<Integer>> makeLotto(int count){
        List<List<Integer>> myLotto = new ArrayList<>();
        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            myLotto.add(lotto.numbers);
        }
        return myLotto;
    }
}
