package lotto;

import lotto.domain.BuyLotto;
import lotto.domain.WinLotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        buyLotto.inputMoney();

        List<Integer> lottoNumbersPurchased = new ArrayList<>();
        lottoNumbersPurchased = buyLotto.numberLotto();

        WinLotto winLotto = new WinLotto();
        winLotto.inputWinningNumber();
        winLotto.inputBonusNumber();
    }
}
