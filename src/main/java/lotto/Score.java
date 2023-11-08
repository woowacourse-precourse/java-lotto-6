package lotto;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private int[] result = {0, 0, 0, 0, 0, 0, 0, 0};

    private boolean checkBonus(List<Integer> numbers, int bonus) {
        for (int num : numbers) {
            if (num == bonus) {
                return true;
            }
        }
        return false;
    }

    public void getScore(Lotto lotto, ArrayList<List<Integer>> numberSet, int bonus) {
        for (List<Integer> numset : numberSet) {
            int score = lotto.calculate(numset);
            boolean flag = checkBonus(numset, bonus);

            if (score == 6) {
                this.result[7]++;
                continue;
            }
            if (score == 5 && flag) {
                this.result[6]++;
                continue;
            }
            this.result[score]++;
        }
    }

    private String printMessage(int count, Prize prize) {
        return prize.getMessage(count);
    }

    public void winner() {
        System.out.println();
        System.out.println(Message.MSG_STATISTICS.getMessage());
        System.out.println(printMessage(result[7], Prize.SIX_PRIZE));
        System.out.println(printMessage(result[6], Prize.FIVE_PRIZE_BONUS));
        System.out.println(printMessage(result[5], Prize.FIVE_PRIZE));
        System.out.println(printMessage(result[4], Prize.FOUR_PRIZE));
        System.out.println(printMessage(result[3], Prize.THREE_PRIZE));
    }

    private long getTotal() {
        long total = 0;

        total += result[7] * Prize.SIX_PRIZE.getPrize();
        total += result[6] * Prize.FIVE_PRIZE_BONUS.getPrize();
        total += result[5] * Prize.FIVE_PRIZE.getPrize();
        total += result[4] * Prize.FOUR_PRIZE.getPrize();
        total += result[3] * Prize.THREE_PRIZE.getPrize();

        return total;
    }

    private double rate() {
        int amount = 0;
        for (int val : result) {
            amount += val;
        }

        return (getTotal() * 100 / (amount * 1000 * 1.0));
    }

    public void printRate() {
        System.out.printf(Message.MSG_RATE_FRONT.getMessage());
        System.out.printf("%.1f", rate());
        System.out.println(Message.MSG_RATE_BACK.getMessage());
    }
}
