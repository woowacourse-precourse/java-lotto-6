package lotto.domain;

import lotto.view.OutputView;

import java.util.List;

import static lotto.controller.LottoController.*;

public enum Winning {

    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    FAIL("", 0);

    private final String status;
    private final int reward;

    Winning(final String status, final int reward) {
        this.status = status;
        this.reward = reward;
    }

    public String getStatus() {
        return status;
    }

    public int getReward() {
        return reward;
    }

    public static void check() {
        for (Lotto myLotto : myLottos) {
            int match = calculate(myLotto, winningLotto);
            boolean isBonus = myLotto.getNumbers().contains(bonusNumber);
            Winning winning = win(match, isBonus);
            resultCounter[winning.ordinal()]++;
        }
        OutputView.printWinningResult(resultCounter);
    }

    private static int calculate(Lotto lotto1, Lotto lotto2) {
        int count = 0;
        List<Integer> list1 = lotto1.getNumbers();
        List<Integer> list2 = lotto2.getNumbers();
        for (Integer number : list1) {
            if (list2.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static Winning win(int match, boolean bonus) {
        if (match == 6) return Winning.FIRST;
        else if (match == 5 && bonus) return Winning.SECOND;
        else if (match == 5) return Winning.THIRD;
        else if (match == 4) return Winning.FOURTH;
        else if (match == 3) return Winning.FIFTH;
        else return Winning.FAIL;
    }
}