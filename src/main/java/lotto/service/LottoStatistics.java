package lotto.service;

import lotto.domain.Lotto;
import lotto.enumClass.Result;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private int userPurchase;
    private List<Lotto> userLottos;
    private Map<Lotto, Integer> winNumber;
    private static final double DIVISOR = 100.0;

    public LottoStatistics(int userPurchase, List<Lotto> userLottos, Map<Lotto, Integer> winNumber) {
        this.userPurchase = userPurchase;
        this.userLottos = userLottos;
        this.winNumber = winNumber;
    }

    public LottoStatistics() {
        super();
    }

    public String calculateWinRate() {
        Map<Result, Integer> resultPrize = crateResultPrize();
        Lotto winLotto = winNumber.keySet().iterator().next();
        int bonusNumber = winNumber.get(winLotto);

        calculatePrize(userLottos, resultPrize, winLotto, bonusNumber);
        resultPrize.forEach((key, value) -> System.out.println(key.getResultMessage() + " - " + value + "개"));

        long totalPrize = calculateTotalPrize(resultPrize);
        System.out.println("총 수익률은 " + calculateWinningPercentage(userPurchase, totalPrize) + "%입니다.");
        return calculateWinningPercentage(userPurchase, totalPrize);
    }

    private void calculatePrize(List<Lotto> userLottos, Map<Result, Integer> resultPrize, Lotto winLotto, int bonusNumber) {
        for (Lotto lotto : userLottos) {
            lotto.getNumbers().removeAll(winLotto.getNumbers());
            int[] prizeResult = cratePrize(lotto, bonusNumber);
            updateResult(resultPrize, prizeResult);
        }
    }

    private String calculateWinningPercentage(int userPurchase, long totalPrize) {
        double div = ((double) totalPrize / (userPurchase * 1000)) * DIVISOR;
        double roundWinRate = Math.round(div * DIVISOR) / DIVISOR;
        if (roundWinRate == (int) roundWinRate) {
            return String.format("%d", (int) roundWinRate);
        }
        return formatDecimal(roundWinRate);
    }

    private String formatDecimal(double winRate) {
        if (winRate != (int) winRate) {
            String result = Double.toString(winRate);
            result = result.replaceAll("0*$", "");
            return result;
        }
        return Double.toString(winRate);
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
