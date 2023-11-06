package lotto;

import View.InputView;
import View.OuputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OuputView outputView = new OuputView();
        int money = inputView.askPurchaseAmount();

        Lottos lottos = new Lottos();
        lottos.buy(money);
        outputView.printUserLottoNumbers(lottos.getLottos());

    }
}
