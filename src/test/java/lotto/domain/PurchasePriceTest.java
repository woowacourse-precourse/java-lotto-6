package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.exception.LottoExceptionMessage;
import lotto.util.OutputTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchasePriceTest extends OutputTest {
    @DisplayName("로또 구입 금액이 양의 1000의 배수가 아니면 에러 메시지가 출력된다.")
    @ParameterizedTest
    @CsvSource({"12", "0", "-1000"})
    void getErrorMessageByNonMultiplePrice(int price) {
        PurchasePrice.from(price);
        assertThat(output()).contains(
                LottoExceptionMessage.MUST_BE_POSITIVE_MULTIPLE.getMessage()
        );
    }

}