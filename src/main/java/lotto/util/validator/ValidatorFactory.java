package lotto.util.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.dto.WinningNumbersDto;

public class ValidatorFactory {
    private static ValidatorFactory validatorFactory;
    private final Set<Validator> validators = new HashSet<>();

    private ValidatorFactory() {
        addValidator(new NumberValidator());
        addValidator(new PurchaseValidator());
        addValidator(new WinningNumbersDtoValidator());
        addValidator(new LottoValidator());
    }

    public static ValidatorFactory getInstance() {
        if (validatorFactory == null) {
            return new ValidatorFactory();
        }
        return validatorFactory;
    }

    public Validator getValidator(Class<?> clazz) {
        return validators.stream()
                .filter(validator -> validator.support(clazz))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void addValidator(Validator validator) {
        validators.add(validator);
    }
}
