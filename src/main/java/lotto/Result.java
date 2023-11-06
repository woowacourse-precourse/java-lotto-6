package lotto;

import java.util.Collections;
import java.util.List;

public class Result {
    private final List<Integer> countLotto;
    private final List<Boolean> countBonusLotto;
    private Double rateOfReturn;

    public Result(List<Integer> countLotto, List<Boolean> countBonusLotto) {
        this.countLotto = countLotto;
        this.countBonusLotto = countBonusLotto;
        this.rateOfReturn = 0.0;
    }

    private Integer count3Match() {
        return Collections.frequency(countLotto, 3);
    }

    private Integer count4Match() {
        return Collections.frequency(countLotto, 4);
    }

    private Integer count5Match() {
        int count = 0;
        for (int i = 0; i < countLotto.size(); i++) {
            if (countLotto.get(i) == 5 && !countBonusLotto.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    private Integer count5MatchWithBonus() {
        int count = 0;
        for (int i = 0; i < countLotto.size(); i++) {
            if (countLotto.get(i) == 5 && countBonusLotto.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    private Integer count6Match() {
        return Collections.frequency(countLotto, 6);
    }

    public void calculateRateOfReturn(int money) {
        rateOfReturn += count3Match() * 5000;
        rateOfReturn += count4Match() * 50000;
        rateOfReturn += count5Match() * 1500000;
        rateOfReturn += count5MatchWithBonus() * 30000000;
        rateOfReturn += count6Match() * 2000000000;
        rateOfReturn = (rateOfReturn / money) * 100;
    }

    public void printResult() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + count3Match());
        System.out.println("4개 일치 (50,000원) - " + count4Match());
        System.out.println("5개 일치 (1,500,000원) - " + count5Match());
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count5MatchWithBonus());
        System.out.println("6개 일치 (2,000,000,000원) - " + count6Match());
        System.out.printf("총 수익률은 %,.1f".formatted(rateOfReturn));
        System.out.println("%입니다.");
    }
}
