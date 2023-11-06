package lotto.config;

import lotto.context.container.implementation.annotationConfig.annotation.bean.Bean;
import lotto.context.container.implementation.annotationConfig.annotation.configuration.Configuration;
import lotto.util.generator.LottoNumbersGenerator;
import lotto.util.generator.LottoNumbersGeneratorImpl;
import lotto.util.lottoFactory.LottoFactory;
import lotto.util.lottoFactory.LottoFactoryImpl;
import lotto.util.matcher.NumbersMatcher;
import lotto.util.matcher.NumbersMatcherImpl;
import lotto.util.parser.NumberParser;
import lotto.util.parser.NumberParserImpl;
import lotto.util.validator.*;

@Configuration
public class UtilConfig {
    @Bean
    public LottoFactory lottoFactory(LottoNumbersGenerator lottoNumbersGenerator) {
        return new LottoFactoryImpl(lottoNumbersGenerator);
    }

    @Bean
    public LottoNumbersGenerator lottoNumbersGenerator() {
        return new LottoNumbersGeneratorImpl();
    }

    @Bean
    public Validator validator(PaymentValidator paymentValidator, NumberValidator numberValidator) {
        return new ValidatorDecorator(paymentValidator, numberValidator);
    }

    @Bean
    public PaymentValidator paymentValidator() {
        return new PaymentValidatorImpl();
    }

    @Bean
    public NumberValidator numberValidator() {
        return new NumberValidatorImpl();
    }

    @Bean
    public NumberParser numberParser() {
        return new NumberParserImpl();
    }

    @Bean
    public NumbersMatcher numbersMatcher() {
        return new NumbersMatcherImpl();
    }
}
