package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.ResultType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResultService {

    public Map<ResultType,Integer> initResult() {
        Map<ResultType,Integer> result = new HashMap<>();
        for(ResultType resultType:ResultType.values()) {
            result.put(resultType,0);
        }
        return result;
    }

    public int compareLotto(Lotto lotto, Lotto winningNumber) {
        int check = 0;
        for(int i=0; i<lotto.getNumbers().size(); i++) {
            if(winningNumber.getNumbers().contains(lotto.getNumbers().get(i))) {
                check++;
            }
        }
        return check;
    }
    public boolean compareBonus(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }

    public double calculateProfit(int amount, int prize) {
        return Double.valueOf((double) prize/amount*100);
    }

    public int calculatePrize(Map<ResultType,Integer> result) {
        int prize = 0;
        Iterator<ResultType> keys = result.keySet().iterator();
        while (keys.hasNext()) {
            ResultType key = keys.next();
            if(result.get(key) !=0) {
                prize += key.getPrize() * result.get(key);
            }
        }
        return prize;
    }

    public ResultType finalResult(int check, boolean bonus) {
        if(check==6)
            return ResultType.SIX;
        if(check==5&&bonus==true)
            return ResultType.FIVEBONUS;
        if(check==5)
            return ResultType.FIVE;
        if(check==4)
            return ResultType.FOUR;
        if(check==3)
            return ResultType.THREE;
        return ResultType.NOTHING;
    }

    public Map<ResultType,Integer> checkLotto(List<Lotto> lottos, Lotto winningNumber, int bonus) {
        int check = 0;
        boolean checkBonus = false;
        Map<ResultType,Integer> finalResult = initResult();
        for(Lotto lotto: lottos) {
            check = compareLotto(lotto,winningNumber);
            checkBonus = compareBonus(lotto,bonus);
            updateResult(check,checkBonus,finalResult);
        }
        return finalResult;
    }
    public void updateResult(int check, boolean checkBonus, Map<ResultType,Integer> finalResult) {
        ResultType resultType = finalResult(check,checkBonus);
        if(finalResult.containsKey(resultType))
            finalResult.put(resultType,finalResult.get(resultType)+1);

    }
}
