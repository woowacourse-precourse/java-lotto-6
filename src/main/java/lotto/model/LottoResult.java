package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private long winningCount;
    private Lottos lottos;
    private WinningNumber winningNumber;
    private List<Integer> result;
    private double earningRate;

    public LottoResult(Lottos lottos, WinningNumber winningNumber, UserAmount userAmount) {
        winningCount = 0;
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        result = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            result.add(0);
        }

        // 결과 계산 로직
        // lottos에서 하나씩 꺼내서 당첨번호와 비교 대조 진행
        for (Lotto lotto : lottos.getBundleLotto()) {
            List<Integer> numbers = lotto.getNumbers();
            winningCount = numbers.stream()
                    .filter(number -> winningNumber.contains(number))
                    .count();

            // 1등
            if (winningCount == 6) {
                result.add(0, result.get(0) + 1);
            }

            // 2등
            if (winningCount == 5 && numbers.contains(winningNumber.getBonusNumber())) {
                result.add(1, result.get(1) + 1);
            }

            // 3,4,5등
            if (winningCount == 5 && !numbers.contains(winningNumber.getBonusNumber())) {
                result.add(2, result.get(2) + 1);
            }

            if (winningCount == 4) {
                result.add(3, result.get(3) + 1);
            }

            if (winningCount == 3) {
                result.add(4, result.get(4) + 1);
            }
        }
        calculateEarningRate(userAmount);
    }

    public Integer getWinningResult(int place) {
        return result.get(place);
    }

    private void calculateEarningRate(UserAmount userAmount) {
        long sumEarning = 0;
        sumEarning += result.get(0) * 2000000000;
        sumEarning += result.get(1) * 30000000;
        sumEarning += result.get(2) * 1500000;
        sumEarning += result.get(3) * 50000;
        sumEarning += result.get(4) * 5000;

        earningRate = (double)sumEarning / userAmount.getAmount() * 100;
    }

    public double getEarningRate() {
        return earningRate;
    }


}
