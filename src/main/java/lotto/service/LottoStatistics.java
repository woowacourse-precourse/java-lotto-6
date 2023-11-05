package lotto.service;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enumClass.Result;

public class LottoStatistics {

    public void calculateWinRate(int userPurchase, List<Lotto> userLottos, Map<Lotto, Integer> winNumber) {
        Map<Result, Integer> result = new EnumMap<>(Result.class);
        for (Result result1 : Result.values()) {
            result.put(result1, 0);
        }

        for (Lotto lotto : userLottos) {
            Lotto winLotto = winNumber.keySet().iterator().next();
            int bonusNumber = winNumber.get(winLotto);
            lotto.getNumbers().removeAll(winLotto.getNumbers());
            int[] prizeResult = new int[2];
            if (lotto.getNumbers().size() <4) {
                prizeResult = new int[]{lotto.getNumbers().size(), 0};
            }
            if (lotto.getNumbers().size() == 1 && lotto.getNumbers().contains(bonusNumber)) {
                prizeResult[1] = 1;
            }

            for (Result result1 : Result.values()) {
                if (Arrays.equals(result1.getPrize(), prizeResult)) {
                    result.put(result1, +1);
                }
            }
        }

        result.forEach((key, value) -> System.out.println(key + "," + value));

        long prize = 0;

        for (Map.Entry<Result, Integer> entry : result.entrySet()) {
            if (entry.getValue() > 0) {
                prize += (entry.getKey().getMoney()) * entry.getValue();
            }
        }

        double div =  ( (double) prize / (userPurchase * 1000))*100;

        double realResult = Math.round(div * 100.0) / 100.0;

        if(realResult == (int) realResult){
            System.out.printf("%.0f",realResult);
        }
        if(realResult != (int) realResult){
            System.out.printf("%.2f",realResult);
        }

        System.out.println(realResult);
    }
}
