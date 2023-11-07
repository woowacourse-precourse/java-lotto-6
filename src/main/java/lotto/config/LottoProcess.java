package lotto.config;

import lotto.view.LottoBuyer;
import lotto.view.LottoDrawer;

public class LottoProcess {

    public static LottoProcess start(LottoBuyer lottoBuyer, LottoDrawer lottoDrawer){
        return new LottoProcess(lottoBuyer, lottoDrawer);
    }

    public LottoProcess(LottoBuyer lottoBuyer, LottoDrawer lottoDrawer){
        lottoProcess(lottoBuyer, lottoDrawer);
    }

    private static void lottoProcess(LottoBuyer lottoBuyer, LottoDrawer lottoDrawer) {
        inputProcess(lottoBuyer, lottoDrawer);
        outputProcess(lottoBuyer);
    }

    private static void inputProcess(LottoBuyer lottoBuyer, LottoDrawer lottoDrawer) {
        lottoBuyer.gernerateTicket();
        lottoDrawer.inputLotto();
        lottoDrawer.inputWinRecord();
    }

    private static void outputProcess(LottoBuyer lottoBuyer) {
        lottoBuyer.printWinRecord();
        lottoBuyer.printReturns();
    }
}
