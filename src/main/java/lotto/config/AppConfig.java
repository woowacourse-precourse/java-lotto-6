package lotto.config;

import lotto.adapter.IoAdapter;
import lotto.adapter.impl.StandardIoAdapter;
import lotto.service.ValidateService;
import lotto.service.impl.ValidateServiceImpl;

public class AppConfig {

    public ValidateService validateService() {
        return new ValidateServiceImpl();
    }

    public IoAdapter ioAdapter() {
        return new StandardIoAdapter();
    }
}
