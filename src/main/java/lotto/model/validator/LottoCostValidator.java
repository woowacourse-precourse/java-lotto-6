package lotto.model.validator;

import java.util.regex.Pattern;
import lotto.common.config.UserRule;
import lotto.common.exception.ErrorMessage;

public class LottoCostValidator extends InputValidator {
    private static final Pattern THOUSAND_UNIT_PATTERN = Pattern.compile(
            String.format("^[1-9]\\d*%s$", UserRule.LOTTO_COST_UNIT.value()));

    public static void validateThousandUnit(String userInputLottoCost) {
        if (!THOUSAND_UNIT_PATTERN.matcher(userInputLottoCost).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_THOUNSAND_UNIT_INPUT.message());
        }
    }
}
