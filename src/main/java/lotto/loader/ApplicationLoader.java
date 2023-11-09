package lotto.loader;

import lotto.context.beanFactory.BeanFactory;
import lotto.context.beanFactory.SimpleBeanFactory;
import lotto.context.container.implementation.annotationConfig.AnnotationConfigApplicationContainer;
import lotto.context.container.ApplicationContainer;
import lotto.controller.LottoController;
import lotto.context.container.implementation.annotationConfig.LoadingStrategy;

public class ApplicationLoader {
    private static final String BASE_PACKAGE = "lotto";
    private static final BeanFactory beanFactory = new SimpleBeanFactory();
    private static final ApplicationContainer container =
            new AnnotationConfigApplicationContainer(beanFactory, LoadingStrategy.EAGER, BASE_PACKAGE);

    public static void run() {
        LottoController controller = container.getBean(LottoController.class);
        controller.play();
    }

    public static ApplicationContainer getContainer() {
        return container;
    }
}
