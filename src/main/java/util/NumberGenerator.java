package util;

import camp.nextstep.edu.missionutils.Randoms;
import enums.Constants;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> generateLottoNumber(){
        generateRandomNumber();
        sortRandomNumbers(randomNumbers);
        return randomNumbers;
    }
    public void generateRandomNumber(){
        randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,Constants.MAX_LOTTO_NUMBER,Constants.LOTTO_NUMBER_SIZE);
    }

    public void sortRandomNumbers(List<Integer> randomNumbers){
        this.randomNumbers = randomNumbers.stream().sorted().toList();
    }
}
