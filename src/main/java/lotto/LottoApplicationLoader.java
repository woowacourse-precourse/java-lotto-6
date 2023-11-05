package lotto;

import lotto.config.ApplicationConfig;
import lotto.container.beanFactory.BeanFactory;
import lotto.container.beanFactory.SimpleBeanFactory;
import lotto.container.container.ApplicationContainer;
import lotto.container.container.DefaultApplicationContainer;
import lotto.controller.LottoController;

public class LottoApplicationLoader {
    private static final BeanFactory beanFactory = new SimpleBeanFactory();
    private static final ApplicationConfig config = new ApplicationConfig();
    private static final ApplicationContainer container = new DefaultApplicationContainer(beanFactory, config);

    public static void run() {
        LottoController controller = container.getBean(LottoController.class);
        controller.play();
    }
}
