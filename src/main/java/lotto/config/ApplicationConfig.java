package lotto.config;

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

@Deprecated
public class ApplicationConfig {
    public LottoController lottoController(Console console, LottoService lottoService) {
        return new LottoControllerImpl(console, lottoService);
    }

    public Console console() {
        return new ConsoleImpl();
    }

    public LottoService lottoService(
            LottoFactory lottoFactory,
            Validator validator,
            NumberParser numberParser,
            NumbersMatcher numbersMatcher
    ) {
        return new LottoServiceImpl(lottoFactory, validator, numberParser, numbersMatcher);
    }

    public LottoFactory lottoFactory(LottoNumbersGenerator lottoNumbersGenerator) {
        return new LottoFactoryImpl(lottoNumbersGenerator);
    }

    public LottoNumbersGenerator lottoNumbersGenerator() {
        return new LottoNumbersGeneratorImpl();
    }

    public Validator validator(PaymentValidator paymentValidator, NumberValidator numberValidator) {
        return new ValidatorDecorator(paymentValidator, numberValidator);
    }

    public PaymentValidator paymentValidator() {
        return new PaymentValidatorImpl();
    }

    public NumberValidator numberValidator() {
        return new NumberValidatorImpl();
    }

    public NumberParser numberParser() {
        return new NumberParserImpl();
    }

    public NumbersMatcher numbersMatcher() {
        return new NumbersMatcherImpl();
    }
}