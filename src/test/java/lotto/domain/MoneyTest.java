package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Money 테스트")
class MoneyTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("0 이하의 수를 넣으면 오류를 띄운다.")
        @ParameterizedTest
        @ValueSource(ints = {0, -1, -2, -1000})
        void createWithNegativeNumber(int number) {
            assertThatThrownBy(() -> new Money(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_POSITIVE_MESSAGE);
        }

        @DisplayName("로또 가격에 맞지 않는 수를 넣으면 오류를 띄운다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 1001, 2001})
        void createWithNonUnitNumber(int number) {
            assertThatThrownBy(() -> new Money(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_UNIT_NUMBER_MESSAGE);
        }

        @DisplayName("로또 가격에 맞는 수를 넣으면 정상작동한다.")
        @Test
        void createWithUnitNumber() {
            assertDoesNotThrow(() -> new Money(LottoConfig.LOTTO_PRICE));
        }

    }

    @DisplayName("count 테스트")
    @Nested
    class count {

        @DisplayName("입력한 금액으로 구매 가능한 로또 개수를 반환한다.")
        @ParameterizedTest
        @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
        void countWithNumber(int money, int count) {
            assertEquals(new Money(money).count(), count);
        }

    }

    @DisplayName("getPrice 테스트")
    @Nested
    class getPrice {

        @DisplayName("입력받은 금액을 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 3000})
        void returnGivenNumber(int number) {
            assertEquals(new Money(number).getPrice(), number);
        }

    }

}