package lotto.util;

import java.util.Map;

public class MoneyCalculation {

    public static int calculateResult(Map<Integer, Integer> resultLottos){
        int sumPrice = 0;
        int winnings[] = {3000,50000,1500000,30000000,2000000000};
            for(int i = 0; i < 5; i++){
               sumPrice += winnings[i] * resultLottos.get(i);
            }

            return sumPrice;

    }
}
