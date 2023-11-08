package lotto;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<String> prizes = new ArrayList<>();

    public void addToPrizes(int match, boolean bonus) {
        for (Prize prize : Prize.values()) {
            if (match == prize.getMatch() && ((bonus == prize.getBonus()) || prize.getBonus())) {
                prizes.add(prize.getName());
            }
        }
    }

    private float totalProfit = 0;

    public void computeTotalProfit(int match, boolean bonus) {
        for (Prize prize : Prize.values()) {
            if (match == prize.getMatch() && ((bonus == prize.getBonus()) || prize.getBonus())) {
                totalProfit += prize.getProfit();
            }
        }
    }

    public float getTotalProfit() {
        return totalProfit;
    }

    public List<Long> countPrizes() {
        List<Long> numbersOfPrizes = new ArrayList<>();
        numbersOfPrizes.add(countFirstPrize(prizes));
        numbersOfPrizes.add(countSecondPrize(prizes));
        numbersOfPrizes.add(countThirdPrize(prizes));
        numbersOfPrizes.add(countFourthPrize(prizes));
        numbersOfPrizes.add(countFifthPrize(prizes));
        return numbersOfPrizes;
    }

    private long countFirstPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("FIRST"))
                .count();
    }

    private long countSecondPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("SECOND"))
                .count();
    }

    private long countThirdPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("THIRD"))
                .count();
    }

    private long countFourthPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("FOURTH"))
                .count();
    }

    private long countFifthPrize(List<String> prizes) {
        return prizes.stream()
                .filter(name -> name.equals("FIFTH"))
                .count();
    }
}
