package lotto.vo;

import lotto.values.CorrectNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WinningResult {
    Map<CorrectNumber, Integer> result;
    public WinningResult(){
        result = new HashMap<>();
        for(CorrectNumber c : CorrectNumber.values()){
            result.put(c, 0);
        }
    }
    public void win(CorrectNumber place){
        result.replace(place, result.get(place)+1);
    }

    public List<Integer> getWinning(){
        List<Integer> winningResult = new ArrayList<>();
        for(CorrectNumber c : CorrectNumber.values()){
            winningResult.add(result.get(c));
        }

        return winningResult;
    }

}
