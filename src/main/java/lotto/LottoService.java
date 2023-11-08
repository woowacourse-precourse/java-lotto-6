package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public void saveWinNumber(String winNumber){
        List<String> tempNumbers = Arrays.asList(winNumber.split(","));
        List<Integer> numbers = new ArrayList<>();
        for(String number: tempNumbers){
            numbers.add(Integer.parseInt(number));
        }
        Lotto lotto = new Lotto(numbers);
    }

    public List<Integer> createLottoList(){
        List<List<Integer>> numbersList = new ArrayList<>();
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(randomNumbers);
        numbersList.add(randomNumbers);
        return randomNumbers;
    }


}
