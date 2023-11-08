package lotto.model;

import lotto.config.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("Money 생성 성공 - 올바른 금액")
    void createMoneySuccessfully() {
        int lottoPrice = LottoConfig.LOTTO_PRICE.getValue();
        String validAmount = String.valueOf(lottoPrice * 10); // Lotto 가격의 배수인 양수

        Money money = Money.from(validAmount);

        assertThat(money.getAmount()).isEqualTo(lottoPrice * 10);
    }

    @Test
    @DisplayName("Money 생성 실패 - null 입력")
    void createMoneyWithNullInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Money.from(null))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Money 생성 실패 - 비정수 입력")
    void createMoneyWithNonIntegerInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Money.from("invalid"))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Money 생성 실패 - 0 이하의 금액")
    void createMoneyWithNonPositiveAmount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Money.from("0"))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000"})
    @DisplayName("Money 생성 실패 - 음수 금액")
    void createMoneyWithNegativeAmount(String amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Money.from(amount))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1001"}) // LottoConfig.LOTTO_PRICE.getValue()로 나누어 떨어지지 않는 금액
    @DisplayName("Money 생성 실패 - 로또 가격의 배수가 아닌 금액")
    void createMoneyWithAmountNotMultipleOfLottoPrice(String amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Money.from(amount))
                .withMessageContaining(ERROR_MESSAGE);
    }

    // 경계 값 분석
    @ParameterizedTest
    @MethodSource("boundaryValueProvider")
    @DisplayName("Money 생성 성공 - 경계 값 테스트")
    void createMoneyWithBoundaryValues(String amount) {
        assertThatCode(() -> Money.from(amount)).doesNotThrowAnyException();
    }

    private static Stream<String> boundaryValueProvider() {
        int lottoPrice = LottoConfig.LOTTO_PRICE.getValue();
        int maxMultipleOfLottoPrice = (Integer.MAX_VALUE / lottoPrice) * lottoPrice;

        return Stream.of(
                String.valueOf(lottoPrice),
                String.valueOf(lottoPrice * 2),
                String.valueOf(maxMultipleOfLottoPrice)
        );
    }
}