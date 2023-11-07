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
        return Collections.frequency(countLotto, Range.THREE.content());
    }

    private Integer count4Match() {
        return Collections.frequency(countLotto, Range.FOUR.content());
    }

    private Integer count5Match() {
        int count = 0;
        for (int i = 0; i < countLotto.size(); i++) {
            if (countLotto.get(i) == Range.FIVE.content() && !countBonusLotto.get(i)) {
                count++;
            }
        }
        return count;
    }

    private Integer count5MatchWithBonus() {
        int count = 0;
        for (int i = 0; i < countLotto.size(); i++) {
            if (countLotto.get(i) == Range.FIVE.content() && countBonusLotto.get(i)) {
                count++;
            }
        }
        return count;
    }

    private Integer count6Match() {
        return Collections.frequency(countLotto, Range.SIX.content());
    }

    public void calculateRateOfReturn(int money) {
        rateOfReturn += count3Match() * Range.MATCH3PRICE.content();
        rateOfReturn += count4Match() * Range.MATCH4PRICE.content();
        rateOfReturn += count5Match() * Range.MATCH5PRICE.content();
        rateOfReturn += count5MatchWithBonus() * Range.MATCH5WITHBONUSPRICE.content();
        rateOfReturn += count6Match() * Range.MATCH6PRICE.content();
        rateOfReturn = (rateOfReturn / money) * 100;
    }

    public void printResult() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + count3Match() + "개");
        System.out.println("4개 일치 (50,000원) - " + count4Match() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + count5Match() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count5MatchWithBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + count6Match() + "개");
        System.out.printf("총 수익률은 %,.1f".formatted(rateOfReturn));
        System.out.println("%입니다.");
    }
}