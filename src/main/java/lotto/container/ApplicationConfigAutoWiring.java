package lotto.container;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.generator.LottoNumbersGenerator;
import lotto.util.generator.LottoNumbersGeneratorImpl;
import lotto.util.lottoFactory.LottoFactory;
import lotto.util.lottoFactory.LottoFactoryImpl;
import lotto.util.matcher.NumbersMatcher;
import lotto.util.matcher.NumbersMatcherImpl;
import lotto.util.parser.NumberParser;
import lotto.util.parser.NumberParserImpl;
import lotto.util.validator.*;
import lotto.view.Console;
import lotto.view.ConsoleImpl;

public class ApplicationConfigAutoWiring {
    private final InstanceFactory factory = new InstanceFactory();

    public int getInstanceCount() {
        return factory.getInstanceCount();
    }

    public LottoController lottoController() {
        String instanceName = "lottoController";
        factory.registerInstance(instanceName, () -> new LottoControllerImpl(console(), lottoService()));
        return factory.get(instanceName);
    }

    public Console console() {
        String instanceName = "console";
        factory.registerInstance(instanceName, ConsoleImpl::new);
        return factory.get(instanceName);
    }

    public LottoService lottoService() {
        String instanceName = "lottoService";
        factory.registerInstance(instanceName, () -> new LottoServiceImpl(
                lottoFactory(), validator(), numberParser(), numbersMatcher()
        ));
        return factory.get(instanceName);
    }

    public LottoFactory lottoFactory() {
        String instanceName = "lottoFactory";
        factory.registerInstance(instanceName, () -> new LottoFactoryImpl(lottoNumbersGenerator()));
        return factory.get(instanceName);
    }

    public LottoNumbersGenerator lottoNumbersGenerator() {
        String instanceName = "lottoNumbersGenerator";
        factory.registerInstance(instanceName, LottoNumbersGeneratorImpl::new);
        return factory.get(instanceName);
    }

    public Validator validator() {
        String instanceName = "validator";
        factory.registerInstance(instanceName, () -> new ValidatorDecorator(paymentValidator(), numberValidator()));
        return factory.get(instanceName);
    }

    public PaymentValidator paymentValidator() {
        String instanceName = "paymentValidator";
        factory.registerInstance(instanceName, PaymentValidatorImpl::new);
        return factory.get(instanceName);
    }

    public NumberValidator numberValidator() {
        String instanceName = "numberValidator";
        factory.registerInstance(instanceName, NumberValidatorImpl::new);
        return factory.get(instanceName);
    }

    public NumberParser numberParser() {
        String instanceName = "numberParser";
        factory.registerInstance(instanceName, NumberParserImpl::new);
        return factory.get(instanceName);
    }

    public NumbersMatcher numbersMatcher() {
        String instanceName = "numberMatcher";
        factory.registerInstance(instanceName, NumbersMatcherImpl::new);
        return factory.get(instanceName);
    }
}
