package lotto.controller;

import lotto.Lotto;
import lotto.model.SixNumberGenerator;
import lotto.util.Constant;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    InputView inputView = new InputView();
    //    OutputView outputView = new OutputView();
    public static int payMoney = 0;
    public static int winningMoney = 0;
    private static int threeCorrect = 0;
    private static int fourCorrect = 0;
    private static int fiveCorrect = 0;
    private static int fiveBonusCorrect = 0;
    private static int sixCorrect = 0;

    public static int getThreeCorrect() {
        return threeCorrect;
    }

    public static int getFourCorrect() {
        return fourCorrect;
    }

    public static int getFiveCorrect() {
        return fiveCorrect;
    }

    public static int getFiveBonusCorrect() {
        return fiveBonusCorrect;
    }

    public static int getSixCorrect() {
        return sixCorrect;
    }

    public void lottoGame() {
        List<Lotto> myLotto = myLotto();
        OutputView.printLottoAmountMessage(myLotto.size());
        OutputView.printLotto(myLotto);
        List<Integer> dangchum = inputView.userInputDangchum();
        int bonus = inputView.userInputBonus(dangchum);
        checkCorrect(dangchum, bonus, myLotto);
        checkProfit();
        OutputView.printCorrectResult();
    }

    public List<Lotto> myLotto() {
        List<Lotto> myLotto = new ArrayList<>();
        payMoney = inputView.userInputMoney();
        int round = payMoney / Constant.LOTTO_PRICE;
        for (int i = 0; i < round; i++) {
            Lotto lotto = new Lotto(SixNumberGenerator.generateNumber());
            myLotto.add(lotto);
        }
        return myLotto;
    }

    public void checkCorrect(List<Integer> dangchum, int bonus, List<Lotto> myLotto) {
        for (Lotto nowLotto : myLotto) {
            int correctCnt = 0;
            List<Integer> calLotto = nowLotto.getNumbers();
            correctCnt = checkLotto(calLotto, dangchum, bonus);
            if (correctCnt == 5) {
                checkBonus(bonus, calLotto);
            }
        }
    }

    public int checkLotto(List<Integer> calLotto, List<Integer> dangchum, int bonus) {
        int correctNum = 0;
        for (int nowNum : calLotto) {
            if (dangchum.contains(nowNum)) {
                correctNum += 1;
            }
        }
        if (correctNum == 3) {
            threeCorrect += 1;
        } else if (correctNum == 4) {
            fourCorrect += 1;
        } else if (correctNum == 6) {
            sixCorrect += 1;
        }
        return correctNum;
    }

    public void checkBonus(int bonus, List<Integer> calLotto) {
        if (calLotto.contains(bonus)) {
            fiveBonusCorrect += 1;
            return;
        }
        fiveCorrect += 1;
    }

    public void checkProfit() {
        winningMoney = Constant.THREE_CORRECT_WINNINGS * threeCorrect
                + Constant.FOUR_CORRECT_WINNINGS * fourCorrect
                + Constant.FIVE_CORRECT_WINNINGS * fiveCorrect
                + Constant.FIVE_BONUX_CORRECT_WINNINGS * fiveBonusCorrect
                + Constant.SIX_CORRECT_WINNINGS * sixCorrect;

    }


}
