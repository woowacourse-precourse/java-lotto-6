package lotto;

import java.util.ArrayList;
import java.util.Arrays;
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



}
