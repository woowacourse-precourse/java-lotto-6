package lotto.config;

import lotto.context.container.implementation.annotationConfig.annotation.bean.Bean;
import lotto.context.container.implementation.annotationConfig.annotation.configuration.Configuration;
import lotto.controller.LottoController;
import lotto.controller.LottoControllerImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.lottoFactory.LottoFactory;
import lotto.util.matcher.NumbersMatcher;
import lotto.util.parser.NumberParser;
import lotto.util.validator.Validator;
import lotto.view.Console;
import lotto.view.ConsoleImpl;

@Configuration
public class LottoConfig {
    @Bean
    public LottoController lottoController(Console console, LottoService lottoService) {
        return new LottoControllerImpl(console, lottoService);
    }

    @Bean
    public Console console() {
        return new ConsoleImpl();
    }

    @Bean
    public LottoService lottoService(
            LottoFactory lottoFactory,
            Validator validator,
            NumberParser numberParser,
            NumbersMatcher numbersMatcher
    ) {
        return new LottoServiceImpl(lottoFactory, validator, numberParser, numbersMatcher);
    }
}
