package Controller;

import Model.Domain;
import Model.Service;

public enum InstanceData {
    DOMAIN(Domain.getInstance()),
    SERVICE(Service.getInstance());

    Object instance;

    InstanceData(Object obj) {
        this.instance = obj;
    }

    public Object getInstance() {
        return this.instance;
    }
}
