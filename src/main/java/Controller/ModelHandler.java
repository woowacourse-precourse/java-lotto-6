package Controller;

import Model.Domain;
import Model.Lotto;
import Model.Service;
import View.InputView;
import java.util.List;

public class ModelHandler {
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

    public List<Integer> setInputWinningNumber() {
        return SERVICE.makeLotto(INPUT_VIEW.inputWinningNumber());
    }

    public int setBonusNumber() {
        return INPUT_VIEW.inputBonusNumber();
    }

    public int setPrice() {
        EXCEPTION.checkPriceUnit(INPUT_VIEW.inputPrice());
        return INPUT_VIEW.inputPrice();
    }
}
