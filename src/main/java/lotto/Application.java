package lotto;

import lotto.View.Input;
import lotto.View.Output;

import java.util.List;

import static lotto.Lotto.getTwoNumbers;
import static lotto.Lotto.issuanceLotto;

public class Application {

    public static void main(String[] args) {

        int lottoCnt;
        int bonus;
        List<List<Integer>> lottoBundle;
        List<Integer> winningNumbers;

        Output.startMessage();
        lottoCnt = issuanceLotto(Input.money());

        Output.howManyLottoMessage(lottoCnt);
        lottoBundle = Lotto.getLottoBundle();

        winningNumbers = Input.winningNumbers();

        bonus = Input.bonusNumber();

        getTwoNumbers(winningNumbers, lottoBundle, bonus);
        Output.resultLotto();
        Output.RateOfReturn();

    }
}
