package lotto.domain;

import java.util.HashMap;

public class WinningResult {

    private final HashMap<Integer, Integer> winningResult;

    public WinningResult(
            HashMap<Integer, Integer> winningResult) {this.winningResult = winningResult;}

    public int getLotteryPrize() {
        return -1;
    }

}
