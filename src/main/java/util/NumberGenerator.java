package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> generateLottoNumber(){
        generateRandomNumber();
        sortRandomNumbers();
        return randomNumbers;
    }
    public void generateRandomNumber(){
        randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public void sortRandomNumbers(){
        Collections.sort(randomNumbers);
    }
}
