package lotto;

import lotto.controller.LottoController;
import lotto.domain.rule.PrizeAmount;
import lotto.input.LottoBuyer;
import lotto.input.LottoDrawer;
import lotto.model.DataModel;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class ApplicationContext {
    private static LottoController lottoController;
    private static LottoBuyer lottoBuyer;
    private static LottoDrawer lottoDrawer;
    private static PrizeAmount prizeAmount;
    private static DataModel dataModel;

    public static ApplicationContext init(){
        return new ApplicationContext();
    }

    private ApplicationContext(){
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
        OutputMessage.print(MessageType.OUTPUT_MATCH_STATICS);
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

    public static DataModel getDataModel(){
        if(dataModel == null){
            dataModel = new DataModel();
        }
        return dataModel;
    }
}
