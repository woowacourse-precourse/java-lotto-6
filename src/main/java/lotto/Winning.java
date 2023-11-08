package lotto;

import java.util.Arrays;
import java.util.List;

public class Winning {
    private List<List<Integer>> buyLottos;
    private List<Integer> numbers;
    private int bonus;
    private int[] numPrize;
    int price;
    private double rate_return;

    public Winning(Purchase purchase, Lotto lotto, int bonus) {
        this.buyLottos = purchase.getBuyLottos();
        this.numbers = lotto.getNumbers();
        this.bonus = bonus;
        this.price = purchase.getPrice();
        numPrize = new int[5 + 3];
        Arrays.fill(numPrize, 0);

        calcMatches();
        calcReturn();
    }

    public void calcMatches() {
        for (List<Integer> buyLotto : buyLottos) {
            int numMatch = matches(buyLotto);

            if (containsBonus(buyLotto, numMatch)) {
                numMatch = Prize.FIVE_BONUS.numMatch();
            }
            if (numMatch >= 3) {
                numPrize[numMatch]++;
            }
        }
    }

    public void calcReturn() {
        int profit = 0;

        profit += Prize.THREE.getPrize() * numPrize[Prize.THREE.numMatch()];
        profit += Prize.FOUR.getPrize() * numPrize[Prize.FOUR.numMatch()];
        profit += Prize.FIVE.getPrize() * numPrize[Prize.FIVE.numMatch()];
        profit += Prize.FIVE_BONUS.getPrize() * numPrize[Prize.FIVE_BONUS.numMatch()];
        profit += Prize.SIX.getPrize() * numPrize[Prize.SIX.numMatch()];

        rate_return = (double) profit / price * 100;
    }

    public int matches(List<Integer> buyLotto) {
        int cnt = 0;
        for (int num : buyLotto) {
            if (numbers.contains(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean containsBonus(List<Integer> buyLotto, int numMatch) {
        if (numMatch == 5) {
            return buyLotto.contains(bonus);
        }
        return false;
    }

    public void print() {
        System.out.println("3개 일치 (5,000원) - " + numPrize[Prize.THREE.numMatch()] + "개");
        System.out.println("4개 일치 (50,000원) - " + numPrize[Prize.FOUR.numMatch()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + numPrize[Prize.FIVE.numMatch()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + numPrize[Prize.FIVE_BONUS.numMatch()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + numPrize[Prize.SIX.numMatch()] + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", rate_return) + "%입니다.");
    }
}
