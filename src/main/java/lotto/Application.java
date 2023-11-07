package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoGame.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCnt;
        int bonus;
        List<List<Integer>> lottoBundle;
        List<Integer> winningNumbers;

        Output.startMessage();
        lottoCnt = issuanceLotto(Input.money());

        Output.howManyLottoMessage(lottoCnt);
        lottoBundle = LottoGame.getLottoBundle();

        Output.winningNumberGuide();
        winningNumbers = Input.winningNumbers();

        Output.bonusNumberGuide();
        bonus = Input.bonusNumber();

        getTwoNumbers(winningNumbers, lottoBundle, bonus);
        Output.resultLotto();
        Output.RateOfReturn();



    }
}
