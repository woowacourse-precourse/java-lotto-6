package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private Map<Result, Integer> lottoResult;

    public LottoMachine() {
        lottoResult = new HashMap<>();
        for (Result r : Result.values()) {
            lottoResult.put(r, 0);
        }
    }

    public void judge(List<Lotto> lottos, List<Integer> correctNumbers, int bonusNumber) {
        int correctNumberCount = 0;
        for (Lotto l : lottos) {
            correctNumberCount = compareNumbers(l, correctNumbers, bonusNumber);
            makeResult(correctNumberCount);
        }
        showResult(lottos.size());
    }

    public int compareNumbers(Lotto lotto, List<Integer> correctNumbers, int bonusNumber) {
        int correctNumberCount = 0;
        for (int n : correctNumbers) {
            if (lotto.hasCorrectNum(n)) {
                correctNumberCount += 2;
            }
        }
        if (lotto.hasCorrectNum(bonusNumber)) {
            correctNumberCount++;
        }
        return correctNumberCount;
    }

    public void makeResult(int correctNumberCount) {
        Result second = Result.SECOND;
        if (second.getSame() == correctNumberCount) {
            lottoResult.put(second, lottoResult.get(second) + 1);
            return;
        }
        correctNumberCount -= correctNumberCount % 2;
        for (Result r : Result.values()) {
            if (r.getSame() == correctNumberCount) {
                lottoResult.put(r, lottoResult.get(r) + 1);
                return;
            }
        }
    }

    public long totalPrize() {
        long total = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Result r : Result.values()) {
            System.out.printf("%s%d개\n", r.getResult(), lottoResult.get(r));
            total += r.getPrizeMoney() * lottoResult.get(r);
        }
        return total;
    }

    public void showResult(int lottoCount) {
        long total = totalPrize();
        double profit = (double) total / (lottoCount * 1000) * 100;
        profit = Math.round(profit * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

}
