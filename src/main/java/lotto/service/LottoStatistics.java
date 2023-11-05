package lotto.service;

import lotto.domain.Lotto;
import lotto.enumClass.Result;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    public String calculateWinRate(int userPurchase, List<Lotto> userLottos, Map<Lotto, Integer> winNumber) {
        Map<Result, Integer> resultPrize = crateResultPrize();
        Lotto winLotto = winNumber.keySet().iterator().next();
        int bonusNumber = winNumber.get(winLotto);

        for (Lotto lotto : userLottos) {
            calculatePrize(resultPrize, lotto, winLotto, bonusNumber);
        }
//        resultPrize.forEach((key, value) -> System.out.println(key + "," + value));

        long totalPrize = calculateTotalPrize(resultPrize);
        return calculateWinningPercentage(userPurchase, totalPrize);
    }

    private String calculateWinningPercentage(int userPurchase, long totalPrize) {
        double div = ((double) totalPrize / (userPurchase * 1000)) * 100.0;
        double roundWinRate = Math.round(div * 100.0) / 100.0;
        if (roundWinRate == (int) roundWinRate) {
            return String.format("%d", (int) roundWinRate);
        }
        return formatDecimal(roundWinRate);
    }

    private String formatDecimal(double winrate) {
        if (winrate != (int) winrate) {
            String result = Double.toString(winrate);
            result = result.replaceAll("0*$", "");
            return result;
        }
        return Double.toString(winrate);
    }

    private Map<Result, Integer> crateResultPrize() {
        Map<Result, Integer> resultPrize = new EnumMap<>(Result.class);
        for (Result result : Result.values()) {
            resultPrize.put(result, 0);
        }
        return resultPrize;
    }

    private int[] cratePrize(Lotto lotto, int bonusNumber) {
        int[] prizeResult = new int[]{lotto.getNumbers().size(), 0};
        if (lotto.getNumbers().size() == 1 && lotto.getNumbers().contains(bonusNumber)) {
            prizeResult[1] = 1;
        }
        return prizeResult;
    }

    private void calculatePrize(Map<Result, Integer> resultPrize, Lotto lotto, Lotto winLotto, int bonusNumber) {
        lotto.getNumbers().removeAll(winLotto.getNumbers());
        int[] prizeResult = cratePrize(lotto, bonusNumber);
        updateResult(resultPrize, prizeResult);
    }

    private void updateResult(Map<Result, Integer> resultPrize, int[] prizeResult) {
        for (Result result : Result.values()) {
            if (Arrays.equals(result.getPrize(), prizeResult)) {
                resultPrize.put(result, resultPrize.get(result) + 1);
            }
        }
    }

    private long calculateTotalPrize(Map<Result, Integer> resultPrize) {
        long prize = 0;
        for (Map.Entry<Result, Integer> entry : resultPrize.entrySet()) {
            if (entry.getValue() > 0) {
                prize += (entry.getKey().getMoney()) * entry.getValue();
            }
        }
        return prize;
    }
}
