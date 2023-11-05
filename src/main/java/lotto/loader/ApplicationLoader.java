package lotto.loader;

import lotto.container.beanFactory.BeanFactory;
import lotto.container.beanFactory.SimpleBeanFactory;
import lotto.container.container.implementation.AnnotationApplicationContainer;
import lotto.container.container.ApplicationContainer;
import lotto.controller.LottoController;
import lotto.container.container.Strategy;

public class ApplicationLoader {
    private static final String BASE_PACKAGE = "lotto";
    private static final BeanFactory beanFactory = new SimpleBeanFactory();
    private static final ApplicationContainer container =
            new AnnotationApplicationContainer(beanFactory, Strategy.EAGER, BASE_PACKAGE);

    public static void run() {
        LottoController controller = container.getBean(LottoController.class);
        controller.play();
    }
}
