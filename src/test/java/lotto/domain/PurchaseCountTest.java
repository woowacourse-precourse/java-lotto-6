package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSetting.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.service.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseCountTest {

    @ParameterizedTest
    @CsvSource({"가나다", "hello"})
    @DisplayName("구매 금액이 수가 아닌 경우, 예외 처리")
    void validatePurchaseAmount(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PurchaseCount(input));

        assertThat(exception.getMessage()).isEqualTo(NOT_NUMERIC.getMessage());
    }


    @ParameterizedTest
    @CsvSource({"1150", "12005"})
    @DisplayName("구매 금액이 나누어 떨어지지 않는 경우, 예외 처리")
    void validatePurchaseAmount2(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PurchaseCount(input));

        assertThat(exception.getMessage()).isEqualTo(
                format(NOT_DIVISIBLE.getMessage(), DIVISOR.getValue())
        );
    }

    @Test
    @DisplayName("구매 금액에 해당하는 만큼 로또를 구매한다.")
    void purchase() {
        PurchaseCount purchaseCount = new PurchaseCount("2000");
        NumberGenerator numberGenerator = new TestNumberGenerator(
                List.of(
                        List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)
                ));
        List<Lotto> lottos = purchaseCount.purchase(numberGenerator);
        assertThat(lottos).hasSize(2);
    }
}