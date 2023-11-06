package Controller;

import Model.Domain;
import Model.Lotto;
import Model.Service;
import java.util.List;

public class ModelHandler {
    private Domain DOMAIN = Domain.getInstance();
    private Service SERVICE = Service.getInstance();

    public List<Lotto> MY_LOTTO = DOMAIN.getMyLotto();
    public List<Integer> CORRECT_NUMBER_COUNT = DOMAIN.getCorrectNumberCount();

    private ModelHandler() {}

    private class Singleton {
       private static final ModelHandler INSTANCE = new ModelHandler();
    }

    public static ModelHandler getInstance() {
        return Singleton.INSTANCE;
    }
}
