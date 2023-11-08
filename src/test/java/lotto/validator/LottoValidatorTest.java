package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {

    @DisplayName("로또 구입 금액이 천원단위가 아니면 예외가 발생한다.")
    @Test
    void validateLottoPurchaseAmount() {

        int validPurchaseAmount = 10000;
        LottoValidator.isValidPurchaseAmount(validPurchaseAmount);

        int invalidPurchaseAmount = 10500;
        assertThatThrownBy(() -> lotto.Validator.LottoValidator.isValidPurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력에 대한 검증")
    @Test
    void validateWinningLottoNumbers() {

        List<Integer> winningLottoNumbers1 = List.of(1, 2, 3, 4, 5, 6);
        LottoValidator.isValidWinningLottoNumbers(winningLottoNumbers1);

        List<Integer> winningLottoNumbers2 = List.of(1, 2, 3, 4, 5, 50);
        assertThatThrownBy(() -> LottoValidator.isValidWinningLottoNumbers(winningLottoNumbers2))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> winningLottoNumbers3 = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> LottoValidator.isValidWinningLottoNumbers(winningLottoNumbers3))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> winningLottoNumbers4 = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> LottoValidator.isValidWinningLottoNumbers(winningLottoNumbers2))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
