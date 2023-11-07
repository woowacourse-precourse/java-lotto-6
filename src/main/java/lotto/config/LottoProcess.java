package lotto.config;

import lotto.view.LottoBuyer;
import lotto.view.LottoDrawer;

public class LottoProcess {
    private final LottoBuyer lottoBuyer;
    private final LottoDrawer lottoDrawer;

    public static LottoProcess start(LottoBuyer lottoBuyer, LottoDrawer lottoDrawer) {
        return new LottoProcess(lottoBuyer, lottoDrawer);
    }

    public LottoProcess(LottoBuyer lottoBuyer, LottoDrawer lottoDrawer){
        this.lottoBuyer = lottoBuyer;
        this.lottoDrawer = lottoDrawer;

        inputProcess();
        outputProcess();
    }

    private void inputProcess() {
        lottoBuyer.gernerateTicket();
        lottoDrawer.inputLotto();
        lottoDrawer.inputWinRecord();
    }

    private void outputProcess() {
        lottoBuyer.printWinRecord();
        lottoBuyer.printReturns();
    }
}
