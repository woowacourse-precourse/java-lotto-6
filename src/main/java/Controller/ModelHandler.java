package Controller;

import Model.Domain;
import Model.Lotto;
import Model.Service;
import View.InputView;
import java.util.List;

public class ModelHandler {
    private final Domain DOMAIN = Domain.getInstance();
    private final Service SERVICE = Service.getInstance();
    private final InputView INPUT_VIEW = InputView.getInstance();
    private final ExceptionHandler EXCEPTION = new ExceptionHandler();

    private ModelHandler() {}

    private class Singleton {
       private static final ModelHandler INSTANCE = new ModelHandler();
    }

    public static ModelHandler getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Integer> setWinningNumber() {
        return SERVICE.makeLotto(INPUT_VIEW.inputWinningNumber());
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
        DOMAIN.sumWinnings();
    }

    public void setWinningRanking() {
        DOMAIN.setWinningRanking();
    }

    public void setRevenueRate() {
        DOMAIN.setRevenueRate();
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
