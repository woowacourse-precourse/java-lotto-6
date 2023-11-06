package Controller;

import Model.Domain;
import Model.Lotto;
import Model.Service;
import java.util.List;

public class ModelHandler {
    private Domain domain = Domain.getInstance();
    private Service service = Service.getInstance();

    private ModelHandler() {}

    private class Singleton {
       private static final ModelHandler INSTANCE = new ModelHandler();
    }

    public static ModelHandler getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Lotto> getMyLotto() {
        return domain.getMyLotto();
    }
}
