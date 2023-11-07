package lotto;

import lotto.console.InputConsole;
import lotto.model.Lotto;
import lotto.model.Capital;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    void run() {
        Capital capital = InputConsole.getPurchaseAmount();

        System.out.println(capital.getNumberOfPurchasedLotto() + "개를 구매했습니다.");
    }


}
