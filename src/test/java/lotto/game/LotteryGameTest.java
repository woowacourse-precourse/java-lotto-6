package lotto.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

import lotto.config.IntegrationTest;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryGameTest extends IntegrationTest {

    @Nested
    @DisplayName("[가격 입력 테스트] ")
    class PriceInputTest {
        @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생합니다.")
        @ValueSource(strings = {"ㅅ", "j", "0!", " ", "\n", "\r", "\t"})
        @ParameterizedTest
        void isIntegerTest(String price) {
            assertSimpleTest(() -> {
                runException(price);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.NOT_NUMBER_MESSAGE.getMessage());
            });
        }

        @DisplayName("1000의 배수가 아닌 값이 입력되면 예외가 발생합니다.")
        @Test
        void thousandTest() {
            assertSimpleTest(() -> {
                runException("1234");
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.NOT_THOUSAND_MESSAGE.getMessage());
            });
        }

        @DisplayName("주문 범위를 벗어난 금액이 입력되면 예외가 발생합니다.")
        @ValueSource(strings = {"100", "1", "-100", "1000000", "9999999999999999999999"})
        @ParameterizedTest
        void rangeTest(String price) {
            assertSimpleTest(() -> {
                runException(price);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.PRICE_OUT_OF_RANGE_MESSAGE.getMessage());
            });
        }
    }
}
