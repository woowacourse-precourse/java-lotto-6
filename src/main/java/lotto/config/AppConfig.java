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
        setLottoModel();
        setLottoBuyer();
        setLottoDrawer();
        setController(lottoModel);
        setPrizeAmount();

        LottoProcess.start(lottoBuyer, lottoDrawer);
    }

    private static void setController(LottoModel lottoModel) {
        if (lottoController == null) {
            lottoController = new LottoController(lottoModel);
        }
    }

    private static void setLottoBuyer() {
        if (lottoBuyer == null) {
            lottoBuyer = new LottoBuyer();
        }
    }

    private static void setLottoDrawer() {
        if (lottoDrawer == null) {
            lottoDrawer = new LottoDrawer();
        }
    }

    private static void setPrizeAmount() {
        if (prizeAmount == null) {
            prizeAmount = new PrizeAmount();
        }
    }

    private static void setLottoModel() {
        if (lottoModel == null) {
            lottoModel = new LottoModel();
        }
    }

    public static LottoController getController() {
        return lottoController;
    }

    public static LottoBuyer getLottoBuyer() {
        return lottoBuyer;
    }

    public static LottoDrawer getLottoDrawer() {
        return lottoDrawer;
    }

    public static PrizeAmount getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoModel getLottoModel() {
        return lottoModel;
    }
}
