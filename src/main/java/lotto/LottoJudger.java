package lotto;

import java.util.List;
import java.util.Map;

public class LottoJudger {
    static enum Result { ALL, FIVE_AND_BONUS, FIVE, FOUR, THREE, NONE }

    private Map<Result, Integer> statisticMap;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoJudger(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initStatisticMap();
    }

    public void judge(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Result result = judgeLotto(lotto);
            statisticMap.put(result, statisticMap.get(result) + 1);
        }
    }

    public void printStatisticOfResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statisticMap.get(Result.THREE) + "개");
        System.out.println("4개 일치 (50,000원) - " + statisticMap.get(Result.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statisticMap.get(Result.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statisticMap.get(Result.FIVE_AND_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statisticMap.get(Result.ALL) + "개");
        //System.out.println("총 수익률은 " +  + "%입니다.");
    }

    private Result judgeLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int count = getCountOfWinningNumbersInLottoNumbers(lottoNumbers);
        boolean isBonus = lottoNumbers.contains(this.bonusNumber);

        if (count == 6)
            return Result.ALL;
        if (count == 5 && isBonus)
            return Result.FIVE_AND_BONUS;
        if (count == 5)
            return Result.FIVE;
        if (count == 4)
            return Result.FOUR;
        if (count == 3)
            return Result.THREE;
        return Result.NONE;
    }

    private int getCountOfWinningNumbersInLottoNumbers(List<Integer> lottoNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private void initStatisticMap() {
        for (Result result : Result.values()) {
            statisticMap.put(result, 0);
        }
    }
}
