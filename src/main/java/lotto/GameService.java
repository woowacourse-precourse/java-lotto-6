package lotto;

import java.util.HashMap;

public class GameService {

    public Double calculateYields(int consumption, int profit) {
        return ((double) profit  / consumption) * 100;
    }

    public int getProfit (HashMap<Integer,Integer> winningList) {
        int profit = 0;
        profit += winningList.get(3) * 5000;
        profit += winningList.get(4) * 50000;
        profit += winningList.get(5) * 1500000;
        profit += winningList.get(9) * 30000000;
        profit += winningList.get(6) * 2000000000;

        return profit;
    }
}
