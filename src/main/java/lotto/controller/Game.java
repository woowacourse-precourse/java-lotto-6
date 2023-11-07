package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPaper;
import lotto.view.GamePrint;

public class Game {

    public void start() {
        GamePrint.inputPrice();
        String totalAmountPrice = Console.readLine();
        buyLotto(totalAmountPrice);
    }

    private void buyLotto(String totalAmountPrice) {
        LottoPaper lottoPaper = new LottoPaper();
        int buyLottoNumber = lottoPaper.buy(totalAmountPrice);
        GamePrint.numberOfPurchases(buyLottoNumber);
    }
}
