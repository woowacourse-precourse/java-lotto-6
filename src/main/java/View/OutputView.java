package View;

import Controller.ModelHandler;

public class OutputView {
    private final ModelHandler MODEL = ModelHandler.getInstance();

    public void printMyLotto() {
        MODEL.setLottoNum();
        MODEL.setMyLotto();
        MODEL.printMyLotto();
    }

    public void printStatistics() {
        MODEL.setDuplicate();
        MODEL.setWinningRanking();
        MODEL.setWinnings();
        MODEL.setRevenueRate();
        MODEL.printStatistics();
    }
}
