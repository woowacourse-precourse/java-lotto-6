package lotto.player;

import lotto.lotto.Lotto;
import lotto.lotto.WinnerLotto;

import static lotto.play.Rule.*;

public class Prize {
    private int firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize;
    private double rate;

    public Prize() {
        firstPrize = secondPrize = thirdPrize = fourthPrize = fifthPrize = 0;
        rate = 0;
    }

    private void lottoPrize(Lotto lotto, WinnerLotto winnerLotto) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winnerLotto.getLotto().getNumbers().contains(number)) {
                count++;
            }
        }
        boolean bonus = false;
        if (lotto.getNumbers().contains(winnerLotto.getBonusNum())) {
            bonus = true;
        }
        if (count == FIFTH.getValue_1()) {
            fifthPrize++;
            return;
        }
        if (count == FOURTH.getValue_1()) {
            fourthPrize++;
            return;
        }
        if (count == THIRD.getValue_1() && bonus == false) {
            thirdPrize++;
            return;
        }
        if (count == SECOND.getValue_1() && bonus == true) {
            secondPrize++;
            return;
        }
        if (count == FIRST.getValue_1()) {
            firstPrize++;
        }
    }

    public void calculateWinLotto(Wallet wallet, WinnerLotto winnerLotto) {
        for (Lotto lotto : wallet.getLottos()) {
            lottoPrize(lotto, winnerLotto);
        }
    }
}
