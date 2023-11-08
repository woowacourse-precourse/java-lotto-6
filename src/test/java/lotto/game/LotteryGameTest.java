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

    @Nested
    @DisplayName("[가격 입력 테스트] ")
    class LottoNumberTest{
        @DisplayName("입력된 숫자가 6개가 아니면 예외가 발생합니다.")
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7,8"})
        @ParameterizedTest
        void numberLengthTest(String numbers){
            String price = "1000";
            assertSimpleTest(()->{
                runException(price, numbers);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
            });
        }

        @DisplayName("중복 숫자가 입력되면 예외가 발생합니다.")
        @ValueSource(strings = {"1,1,2,3,4,5", "1,2,2,2,2,6"})
        @ParameterizedTest
        void duplicateNumberTest(String numbers){
            String price = "1000";
            assertSimpleTest(()->{
                runException(price, numbers);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
            });
        }

        @DisplayName("중복 숫자가 입력되면 예외가 발생합니다.")
        @ValueSource(strings = {"1,46,2,3,4,5", "-1,2,2,2,2,6"})
        @ParameterizedTest
        void numberOutOfRangeTest(String numbers){
            String price = "1000";
            assertSimpleTest(()->{
                runException(price, numbers);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
            });
        }

        @DisplayName("보너스 번호에 중복 숫자가 입력되면 예외가 발생합니다.")
        @ValueSource(strings = {"1", "6"})
        @ParameterizedTest
        void duplicateBonusNumberTest(String bonusNumber){
            String price = "1000";
            String numbers = "1,2,3,4,5,6";
            assertSimpleTest(()->{
                runException(price, numbers, bonusNumber);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
            });
        }

        @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생합니다.")
        @ValueSource(strings = {"-20", "46","0","99999999999999999999999999", "-99999999999999999999999999999999"})
        @ParameterizedTest
        void bonusNumberOutOfRangeTest(String bonusNumber){
            String price = "1000";
            String numbers = "1,2,3,4,5,6";
            assertSimpleTest(()->{
                runException(price, numbers, bonusNumber);
                assertThat(output()).contains(Messasge.ERROR);
                assertThat(output()).contains(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
            });
        }
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void getProfitRateTest(){
        // given
        int cost = 9000;
        long reward = 5000;

        // when
        double rate = (double) reward/cost;
        String result = String.format("%.1f", rate);

        // then
        assertThat(result).isEqualTo("0.6");
    }
}
