package lotto;

import lotto.io.ConsoleManager;

public class LottoManager {

    private final ConsoleManager consoleManager;
    private final LottoBuyer lottoBuyer;

    protected LottoManager() {
        this.consoleManager = new ConsoleManager();
        this.lottoBuyer = new LottoBuyer(consoleManager);
    }

    protected void buyLotto() {
        long lottoPrice = lottoBuyer.payLotto();

        long lottoCount = lottoBuyer.getLottoCount(lottoPrice);
        consoleManager.printLottoCount(lottoCount);
    }

}
