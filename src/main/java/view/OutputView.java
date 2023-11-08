package view;

import static util.ConstantUtil.CORRECT_FIVE;
import static util.ConstantUtil.CORRECT_FIVE_AND_BONUS;
import static util.ConstantUtil.CORRECT_FOUR;
import static util.ConstantUtil.CORRECT_SIX;
import static util.ConstantUtil.CORRECT_THREE;
import static util.ConstantUtil.DASH;
import static util.ConstantUtil.INPUT_BONUS_NUMBER;
import static util.ConstantUtil.INPUT_WINNER_NUMBER;
import static util.ConstantUtil.NUMBER;
import static util.ConstantUtil.PROFIT_END;
import static util.ConstantUtil.TOTAL_PROFIT_RATE;
import static util.ConstantUtil.USER_BUY_NUMBER;
import static util.ConstantUtil.USER_INPUT_PAY;
import static util.ConstantUtil.WINNER_STATS;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public void userInputPayNumber() {
        System.out.println(USER_INPUT_PAY);
    }

    public void userPurchaseNumber(int cost, List<Lotto> lottos) {
        System.out.println(cost+ USER_BUY_NUMBER);
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinnerNumber() {
        System.out.println(INPUT_WINNER_NUMBER);
    }

    public void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printResultGame() {
        System.out.println(WINNER_STATS);
        System.out.println(DASH * 3);
    }

    public void printCorrectThree(int number) {
        System.out.println(CORRECT_THREE + ' ' + DASH + ' '+ number + NUMBER);
    }

    public void printCorrectFour(int number) {
        System.out.println(CORRECT_FOUR + ' ' + DASH + ' '+ number + NUMBER);
    }

    public void printCorrectFive(int number) {
        System.out.println(CORRECT_FIVE + ' ' + DASH + ' '+ number + NUMBER);
    }

    public void printCorrectFiveAndBonus(int number) {
        System.out.println(CORRECT_FIVE_AND_BONUS + ' ' + DASH + ' '+ number + NUMBER);
    }

    public void printCorrectSix(int number) {
        System.out.println(CORRECT_SIX + ' ' + DASH + ' '+ number + NUMBER);
    }

    public void printProfitRate(double percent) {
        System.out.println(TOTAL_PROFIT_RATE + percent + PROFIT_END);
    }

}
