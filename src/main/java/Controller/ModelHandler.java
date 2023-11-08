package Controller;

import Model.Domain;

public class ModelHandler {
    private final Domain DOMAIN = Domain.getInstance();
    private final ExceptionHandler EXCEPTION = new ExceptionHandler();

    private ModelHandler() {}

    private class Singleton {
       private static final ModelHandler INSTANCE = new ModelHandler();
    }

    public static ModelHandler getInstance() {
        return Singleton.INSTANCE;
    }

    public void setWinningNumber(String winningNumber) {
        DOMAIN.setLottoWinningNumber(winningNumber);
    }

    public void setBonusNumber(int bonusNumber) {
        DOMAIN.setBonusNumber(bonusNumber);
    }

    public void setPrice(int price) {
        EXCEPTION.checkPriceUnit(price);
        DOMAIN.setPrice(price);
    }

    public void setLottoNum() {
        DOMAIN.setLottoNum();
    }

    public void setWinnings() {
        DOMAIN.calculateWinnings();
    }

    public void setWinningRanking() {
        DOMAIN.setWinningRanking();
    }

    public void setRevenueRate() {
        DOMAIN.calculateRevenueRate();
    }

    public void setMyLotto() {
        DOMAIN.setMyLotto();
    }

    public void setDuplicate() {
        DOMAIN.compareNumbers();
    }

    public void printMyLotto() {
        DOMAIN.printMyLotto();
    }

    public void printStatistics() {
        DOMAIN.printStatistics();
    }
}
