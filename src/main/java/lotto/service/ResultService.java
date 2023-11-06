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
}
