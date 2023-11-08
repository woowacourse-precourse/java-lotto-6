package lotto;

import enums.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.Printer.*;
import static io.UserInputValidate.*;
import static lotto.Lotto.*;
import static generator.Generator.*;
import static lotto.Calculator.*;

public class Application {
    static final int invalidInput = -1;
    static final int validLottoLength = 6;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int userMoneyAmount = invalidInput;
        while (userMoneyAmount == invalidInput) {
            printMoneyInput();
            userMoneyAmount = judgeValidationOfUserMoney();
        }

        int lotteryAmount = lottoAmount(userMoneyAmount);
        printLottoAmount(lotteryAmount);

        List<Lotto> lottos = makeLottos(lotteryAmount);

        List<Integer> winningLotto = new ArrayList<Integer>();
        while (winningLotto.size() != validLottoLength) {
            printWinningNumInput();
            winningLotto = makeWinningLottery(judgeValidationOfWinningNum());
        }

        int bonusNum = invalidInput;
        while (bonusNum == invalidInput) {
            printBonusNumInput();
            bonusNum = judgeValidationOfBonus(winningLotto);
        }

        HashMap<Prize, Integer> ranking = makeRankings(lottos, winningLotto, bonusNum);

        printResult(ranking);
        float rate = calculateRate(ranking, userMoneyAmount);
        printRate(rate);
    }
}
