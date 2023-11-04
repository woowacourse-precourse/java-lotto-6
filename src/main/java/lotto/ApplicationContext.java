package lotto;

import lotto.controller.LottoController;
import lotto.input.LottoBuyer;
import lotto.input.LottoDrawer;

public class ApplicationContext {
    private static LottoController lottoController;
    private static LottoBuyer lottoBuyer;
    private static LottoDrawer lottoDrawer;

    public static ApplicationContext init(){
        return new ApplicationContext();
    }

    private ApplicationContext(){
        getController();
        getLottoBuyer();
        getLottoDrawer();
        lottoProcess();
    }

    private void lottoProcess() {
        lottoBuyer.gernerateLotto();
        lottoDrawer.drawNumber();
        lottoBuyer.verifyWinRecord();
        lottoBuyer.verifyReturns();
    }

    public static LottoController getController() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }

        return lottoController;
    }

    public static LottoBuyer getLottoBuyer() {
        if (lottoBuyer == null) {
            lottoBuyer = new LottoBuyer();
        }

        return lottoBuyer;
    }

    public static LottoDrawer getLottoDrawer() {
        if (lottoDrawer == null) {
            lottoDrawer = new LottoDrawer();
        }

        return lottoDrawer;
    }
}
