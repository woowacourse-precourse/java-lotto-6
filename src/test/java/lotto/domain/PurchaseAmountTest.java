package lotto.domain;

import lotto.utils.message.PurchaseAmountExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 999, 100000001, -1, -999})
    @DisplayName("[Exception] 유효하지 않은 구입 금액 범위 입력")
    void invalidRange(int wrongInput) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(wrongInput))
                .hasMessage(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1100, 200001, 3001001, 40000111, 10000100})
    @DisplayName("[Exception] 1000원 단위가 아닌 입력")
    void invalidAmountUnit(int wrongInput) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(wrongInput))
                .hasMessage(PurchaseAmountExceptionMessage.INVALID_AMOUNT_UNIT.getError());
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "12000:12", "30000:30", "12345000:12345",
            "111000:111", "59595000:59595", "100000000:100000"}, delimiter = ':')
    @DisplayName("[Success] 1,000원 가격에 맞게 로또 개수를 반환")
    void lottoTotalCount(int purchaseAmountInput, int expectedLottoCount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountInput);
        Assertions.assertThat(purchaseAmount.getPurchaseLottoCount()).isEqualTo(expectedLottoCount);
    }
}