package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.ResultType;
import lotto.domain.WinningNumber;

import java.util.HashMap;
import java.util.Map;

public class ResultService {

    public Map<ResultType,Integer> initResult() {
        Map<ResultType,Integer> result = new HashMap<>();
        for(ResultType resultType:ResultType.values()) {
            result.put(resultType,0);
        }
        return result;
    }

    public int compareLotto(Lotto lotto, WinningNumber winningNumber) {
        int check = 0;
        for(int i=0; i<lotto.getNumbers().size(); i++) {
            if(winningNumber.getWinningNumber().contains(lotto.getNumbers().get(i))) {
                check++;
            }
        }
        return check;
    }
    public boolean compareBonus(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }

    public double calculateProfit(int purchase, int win) {
        return Double.valueOf((double) win/purchase*100);
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
}
