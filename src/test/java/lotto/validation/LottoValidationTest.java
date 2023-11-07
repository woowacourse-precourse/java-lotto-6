package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidationTest {

    LottoValidation lottoValidation = new LottoValidation();

    @Test
    @DisplayName("구매 금액은 1,000원 단위로 숫자만 입력해야 한다.")
    void validatePurchasePrice() {
        // given
        String notDigitValue = "1000j";
        String notDivisibleValue = "10001";
        String divisibleValue = "1000";

        // then
        String notDigitValueMessage = assertThrows(IllegalArgumentException.class,
                () -> lottoValidation.validatePurchasePrice(notDigitValue)).getMessage();
        assertEquals("[ERROR] 숫자만 입력해 주세요.", notDigitValueMessage);

        String notDivisibleValueMessage = assertThrows(IllegalArgumentException.class,
                () -> lottoValidation.validatePurchasePrice(notDivisibleValue)).getMessage();
        assertEquals("[ERROR] 천원 단위로 입력해 주세요.", notDivisibleValueMessage);

        assertThatNoException().isThrownBy(() -> lottoValidation.validatePurchasePrice(divisibleValue));
    }

    @Test
    @DisplayName("로또 번호는 6자리여야 하며, 범위는 1부터 45 사이의 숫자여야 한다.")
    void validateLottoNumbers() {
        // given
        List<Integer> outOfRange = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> fiveLength = List.of(1, 2, 3, 4, 5);
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

        // then
        String outOfRangeMessage = assertThrows(IllegalArgumentException.class,
                () -> lottoValidation.validateLottoNumbers(outOfRange)).getMessage();
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", outOfRangeMessage);

        String fiveLengthMessage = assertThrows(IllegalArgumentException.class,
                () -> lottoValidation.validateLottoNumbers(fiveLength)).getMessage();
        assertEquals("[ERROR] 로또 숫자는 6자리여야 합니다.", fiveLengthMessage);

        assertThatNoException().isThrownBy(() -> lottoValidation.validateLottoNumbers(lotto));
    }
}