package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    List<Integer> randomNumbers = new ArrayList<>();
    public List<Integer> generate(){
        randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        sortRandomNumbers(randomNumbers);
        return randomNumbers;
    }

    public void sortRandomNumbers(List<Integer> randomNumbers){
        Collections.sort(this.randomNumbers);
    }
}
