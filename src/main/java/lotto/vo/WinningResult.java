package lotto.vo;

import lotto.values.CorrectNumber;

import java.util.HashMap;
import java.util.Map;

import static lotto.values.CorrectNumber.FIFTH_PLACE;

public class WinningResult {

    Map<CorrectNumber, Integer> result;
    public WinningResult(){
        result = new HashMap<>();
        for(CorrectNumber c : CorrectNumber.values()){
            System.out.println(c);
            result.put(c, 0);
        }
    }
    public void win(CorrectNumber place){
        result.replace(place, result.get(place)+1);
    }

}
