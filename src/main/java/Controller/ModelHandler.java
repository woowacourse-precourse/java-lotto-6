package Controller;

import Model.Domain;
import Model.Service;

public class ModelHandler {
    public Domain domain = Domain.getInstance();
    public Service service = Service.getInstance();

    private ModelHandler() {}

    private class Singleton {
       private static final ModelHandler INSTANCE = new ModelHandler();
    }

    public static ModelHandler getInstance() {
        return Singleton.INSTANCE;
    }
}
