package lotto.domain;

import java.util.Hashtable;

public class Statistic {
    private Hashtable<Prize, Integer> prizeCounts;
    private double benefit = 0;

    public Statistic() {
        prizeCounts = new Hashtable<>();
        for (Prize prize : Prize.values()) {
            prizeCounts.put(prize, 0);
        }
    }

    public void incrementPrizeCount(Prize prize) {
        // 특정 상금의 당첨 횟수를 증가시킴
        int currentCount = prizeCounts.get(prize);
        prizeCounts.put(prize, currentCount + 1);
    }

    public int getPrizeCount(Prize prize) {
        return prizeCounts.get(prize);
    }

    public Money getMoneySpent(Money ticketPrice){
        return new Money(prizeCounts.values().stream().
                mapToInt(Integer::intValue).sum() * ticketPrice.getAmount());
    }

    public Money getTotalPrizeSum(){
        return new Money(prizeCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum());
    }


    public void setBenefit(double benefit) {
        this.benefit = benefit;
    }

    public double getBenefit() {
        return benefit;
    }
}