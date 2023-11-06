package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.rule.PrizeAmount;
import lotto.model.LottoModel;
import lotto.view.LottoBuyer;
import lotto.view.LottoDrawer;

public class AppConfig {
    private static LottoController lottoController;
    private static LottoBuyer lottoBuyer;
    private static LottoDrawer lottoDrawer;
    private static PrizeAmount prizeAmount;
    private static LottoModel lottoModel;

    public static AppConfig init(){
        return new AppConfig();
    }

    private AppConfig(){
        getController();
        getLottoBuyer();
        getLottoDrawer();
        getPrizeAmount();
        lottoProcess();
    }

    private void lottoProcess() {
        inputProcess();
        outputProcess();
    }

    private static void inputProcess() {
        lottoBuyer.gernerateTicket();
        lottoDrawer.inputLotto();
        lottoDrawer.inputBonus();
        lottoDrawer.inputWinRecord();
    }

    private static void outputProcess() {
        lottoBuyer.printWinRecord();
        lottoBuyer.printReturns();
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

    public static PrizeAmount getPrizeAmount(){
        if(prizeAmount == null){
            prizeAmount = new PrizeAmount();
        }
        return prizeAmount;
    }

    public static LottoModel getDataModel(){
        if(lottoModel == null){
            lottoModel = new LottoModel();
        }
        return lottoModel;
    }
}
