package lotto.view;

import static lotto.common.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.domain.constant.LottoNumberConstant.MAX_LOTTO_NUMBER;
import static lotto.domain.constant.LottoNumberConstant.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.common.validator.NumericValidator;
import lotto.common.validator.StringValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseAmount;

public enum InputValidator {

    INSTANCE;

    public void validatePurchaseAmount(String amountLiteral) {
        StringValidator.validateInteger(amountLiteral, "%s 숫자를 입력해주세요.".formatted(ERROR_PREFIX));
        int amount = Integer.parseInt(amountLiteral);

        NumericValidator.validatePositiveInteger(amount, "%s 구입 금액은 양수여야 합니다.".formatted(ERROR_PREFIX));
        NumericValidator.validateDivisible(
                amount,
                LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD,
                "%s 구입 금액은 %d원 단위로 입력해주세요."
                        .formatted(ERROR_PREFIX, LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD)
        );
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        NumericValidator.validateNumberSize(
                numbers,
                Lotto.DEFAULT_NUMBER_SIZE,
                "%s 당첨 번호는 %d개 입력해야합니다.".formatted(ERROR_PREFIX, Lotto.DEFAULT_NUMBER_SIZE)
        );
        NumericValidator.validateNumberRange(
                numbers,
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                "%s 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(
                        ERROR_PREFIX,
                        MIN_LOTTO_NUMBER,
                        MAX_LOTTO_NUMBER
                )
        );
        NumericValidator.validateNotDuplicated(numbers, "%s 당첨 번호는 중복될 수 없습니다.".formatted(ERROR_PREFIX));
    }

}
