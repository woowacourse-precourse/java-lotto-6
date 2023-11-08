package lotto.model;

import java.util.List;
import lotto.constant.Number;

public class WinningData {
    private final int hitCount;
    private final int hitBonusNumber;
    private final int WinningAmount;


    WinningData(List<Integer> winningDatas) {
        this.hitCount = winningDatas.get(Number.HIT_COUNT_INDEX.getMessage());
        this.hitBonusNumber = winningDatas.get(Number.HIT_BONUS_INDEX.getMessage());
        this.WinningAmount = winningDatas.get(Number.WINNING_AMOUNT_INDEX.getMessage());
    }

    public static WinningData inputWinningDatas(List<Integer> winningDatas) {
        return new WinningData(winningDatas);
    }

    public int getHitNumber() {
        return hitCount;
    }

    public int getHitBonusNumber() {
        return hitBonusNumber;
    }

    public int getWinningAmount() {
        return WinningAmount;
    }
}





