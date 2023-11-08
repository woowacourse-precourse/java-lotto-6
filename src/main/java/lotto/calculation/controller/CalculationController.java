package lotto.calculation.controller;

import static lotto.calculation.model.CalculationConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.calculation.view.CalculationView;
import lotto.lotto.model.Lotto;

public class CalculationController {
    private CalculationController(){ }
    private static final CalculationController instance = new CalculationController();
    public static CalculationController getInstance(){ return instance; }

    public int calculation(List<Lotto> lottos, List<Integer> numbers, int bonus){
        Map<Integer, Integer> result = createResultMap();
        int totalAmount = 0;
        for(Lotto lotto : lottos){
            Map<String, Integer> temp = compareLotto(lotto, numbers, bonus);
            totalAmount += compareResult(temp.get(NUMBER), temp.get(BONUS), result);
        }
        CalculationView.printResult(result);
        return totalAmount;
    }

    public void calcRevenue(int purchase, int totalAmount){
        float revenue = 100 + (totalAmount - purchase) / (float)purchase * 100;
        CalculationView.printRevenue(revenue);
    }

    private int compareResult(int number, int bonus, Map<Integer, Integer> result){
        int total = 0;
        if(number == 6){
            result.put(FIRST_PLACE, result.get(FIRST_PLACE) + 1);
            total += FIRST_PLACE;
        }
        if(number == 5 && bonus == 1){
            result.put(SECOND_PLACE, result.get(SECOND_PLACE) + 1);
            total += SECOND_PLACE;
        }
        if(number == 5){
            result.put(THIRD_PLACE, result.get(THIRD_PLACE) + 1);
            total += THIRD_PLACE;
        }
        if(number == 4){
            result.put(FOURTH_PLACE, result.get(FOURTH_PLACE) + 1);
            total += FOURTH_PLACE;
        }
        if(number == 3){
            result.put(FIFTH_PLACE, result.get(FIFTH_PLACE) + 1);
            total += FIFTH_PLACE;
        }
        return total;
    }

    private Map<String, Integer> compareLotto(Lotto lotto, List<Integer> numbers, int bonus){
        Map<String, Integer> match = createLottoMap();
        for(int lottoNumber : lotto.getAll()){
            if(compareNumber(lottoNumber, numbers)){
                match.put(NUMBER, match.get(NUMBER) + 1);
            }
            if(compareBonus(lottoNumber, bonus)){
                match.put(BONUS, match.get(BONUS) + 1);
            }
        }
        return match;
    }

    private Map<Integer, Integer> createResultMap(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(FIRST_PLACE, 0);
        map.put(SECOND_PLACE, 0);
        map.put(THIRD_PLACE, 0);
        map.put(FOURTH_PLACE, 0);
        map.put(FIFTH_PLACE, 0);
        return map;
    }

    private Map<String, Integer> createLottoMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put(NUMBER, 0);
        map.put(BONUS, 0);
        return map;
    }

    private boolean compareNumber(int lottoNumber, List<Integer> numbers){
        for(int number : numbers){
            if(lottoNumber == number)
                return true;
        }
        return false;
    }

    private boolean compareBonus(int lottoNumber, int bonus){
        return lottoNumber == bonus;
    }
}
