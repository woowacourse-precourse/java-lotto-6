package lotto;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int gameCount = Lotto.inputYourMoney();

        List<List<Integer>> myLottoNumber = Lotto.myLottoNumber(gameCount);

        List<Integer> winningNumber = Lotto.winningNumber();

        Lotto lotto = new Lotto(winningNumber);

        int bonusNumber = lotto.bonusNumber();

        lotto.lottoGame(gameCount, bonusNumber, myLottoNumber);

    }
}
