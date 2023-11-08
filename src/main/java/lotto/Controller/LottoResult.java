package lotto.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final ArrayList<List<Integer>> lottos;
    private final List<Integer> numbers;
    private final Integer bonus;
    public LottoResult(ArrayList<List<Integer>> lottos, List<Integer> numbers, Integer bonus) {
        this.lottos = lottos;
        this.numbers = numbers;
        this.bonus = bonus;
    }
    public List<Integer> getLottoResult(){
        List<Integer> result = matchLotto(lottos,numbers,bonus);
        return result;
    }
    public Integer matchCount(List<Integer> lotto, List<Integer> numbers){
        Integer match = 0;
        for(Integer number : numbers){
            if(lotto.contains(number)){
                match++;
            }
        }
        return match;
    }
    public List<Integer> matchLotto(ArrayList<List<Integer>> lottos, List<Integer> numbers,Integer bonus){
        List<Integer> result = new ArrayList<>(Collections.nCopies(5,0));
        for(List<Integer> lotto : lottos){
            Integer match = matchCount(lotto,numbers);
            if(match == 6){
                result.set(0,result.get(0)+1);
            } else if(match == 5 && lotto.contains(bonus)){
                result.set(1,result.get(1)+1);
            } else if(match == 5){
                result.set(2,result.get(2)+1);
            } else if(match == 4){
                result.set(3,result.get(3)+1);
            } else if(match == 3){
                result.set(4,result.get(4)+1);
            }
        }
        return result;
    }



}


