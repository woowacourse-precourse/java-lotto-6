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

    public void printTotalResult(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH.addString(fifthPrize));
        System.out.println(FOURTH.addString(fourthPrize));
        System.out.println(THIRD.addString(thirdPrize));
        System.out.println(SECOND.addString(secondPrize));
        System.out.println(FIRST.addString(firstPrize));
    }
    public void printTotalWinRate(Wallet wallet){
        rate = (double)((firstPrize * 2000000000) + (secondPrize * 30000000) + (thirdPrize * 1500000) + (fourthPrize * 50000) + (fifthPrize * 5000)) / wallet.getBuyMoney();
        rate = rate * 100;
        System.out.printf("총 수익률은 %.1f",rate);
        System.out.println("%입니다.");
    }
}
