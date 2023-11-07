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

    public List<Lotto> MY_LOTTO = DOMAIN.getMyLotto();
    public List<Integer> CORRECT_NUMBER_COUNT = DOMAIN.getCorrectNumberCount();

    private ModelHandler() {}

    private class Singleton {
       private static final ModelHandler INSTANCE = new ModelHandler();
    }

    public static ModelHandler getInstance() {
        return Singleton.INSTANCE;
    }

    public void setInputPrice() {
         EXCEPTION.checkPriceUnit(INPUT_VIEW.inputPrice());
         DOMAIN.setPrice(INPUT_VIEW.inputPrice());
    }

    public void setInputWinningNumber() {
        DOMAIN.setLottoWinningNumber(SERVICE.makeLotto(INPUT_VIEW.inputWinningNumber()));
    }

    public void setInputBonusNumber() {

        DOMAIN.setBonusNumber(INPUT_VIEW.inputBonusNumber());
    }
}
