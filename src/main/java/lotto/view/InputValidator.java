package lotto.view;

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
        StringValidator.validateInteger(amountLiteral);
        int amount = Integer.parseInt(amountLiteral);

        NumericValidator.validatePositiveInteger(amount, "구입 금액은 양수여야 합니다.");
        NumericValidator.validateDivisible(
                amount,
                LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD,
                "구입 금액은 %d원 단위로 입력해주세요.".formatted(LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD)
        );
    }

    public void validateBonusNumber(String numberLiteral) {
        StringValidator.validateInteger(numberLiteral);
        int number = Integer.parseInt(numberLiteral);

        NumericValidator.validateNumberRange(
                number,
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                "보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        );
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        NumericValidator.validateNumberSize(
                numbers,
                Lotto.DEFAULT_NUMBER_SIZE,
                "당첨 번호는 %d개 입력해야합니다.".formatted(Lotto.DEFAULT_NUMBER_SIZE)
        );
        NumericValidator.validateNumberRange(
                numbers,
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        );
        NumericValidator.validateNotDuplicated(numbers, "당첨 번호는 중복될 수 없습니다.");
    }
}
