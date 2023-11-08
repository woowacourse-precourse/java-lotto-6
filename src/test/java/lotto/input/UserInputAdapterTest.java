package lotto.input;

import lotto.domain.LottoAnswer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("UserInputPort 클래스는")
class UserInputAdapterTest {
    @Nested
    @DisplayName("getLottoBuyPrice로")
    class GetLottoBuyPriceTest {
        @DisplayName("로또 구입 금액을 입력받아 정수로 반환한다.")
        @Test
        void getLottoBuyPrice() {
            // given
            String input = "1000";
            UserInputAdapter adapter = new UserInputAdapter(() -> input);

            // when
            int lottoBuyPrice = adapter.getLottoBuyPrice();

            // then
            assertThat(lottoBuyPrice).isEqualTo(1000);
        }

        @DisplayName("올바르지 않은 로또 구입 금액을 입력받으면 올바른 값을 입력할 때까지 다시 입력받는다.")
        @Test
        void getLottoBuyPriceWithInvalidInput() {
            // given
            String negativeNumber = "-1000";
            String notMultipleOfLottoPriceNumber = "1";
            String notNumber = "a";

            Supplier<String> inputFunction = mock(Supplier.class);
            when(inputFunction.get())
                    .thenReturn(negativeNumber)
                    .thenReturn(notMultipleOfLottoPriceNumber)
                    .thenReturn(notNumber)
                    .thenReturn("1000");

            UserInputAdapter adapter = new UserInputAdapter(inputFunction);

            // when
            int lottoBuyPrice = adapter.getLottoBuyPrice();

            // then
            assertThat(lottoBuyPrice).isEqualTo(1000);
        }
    }

    @Nested
    @DisplayName("getLottoAnswer로")
    class GetLottoAnswerTest {
        @DisplayName("로또 정답과 보너스 번호를 입력받아 로또 정답을 반환한다.")
        @Test
        void getLottoAnswer() {
            // given
            String input = "1,2,3,4,5,6";
            String bonusInput = "7";

            Supplier<String> inputFunction = mock(Supplier.class);
            when(inputFunction.get())
                    .thenReturn(input)
                    .thenReturn(bonusInput);

            UserInputAdapter adapter = new UserInputAdapter(inputFunction);

            // when
            LottoAnswer lottoAnswer = adapter.getLottoAnswer();

            // then
            assertThat(lottoAnswer.lottoNumbers()).contains(1, 2, 3, 4, 5, 6);
            assertThat(lottoAnswer.lottoBonusNumber()).isEqualTo(7);
        }

        @DisplayName("올바르지 않은 로또 정답을 입력받으면 올바른 값을 입력할 때까지 다시 입력받는다.")
        @Test
        void getLottoAnswerWithInvalidInput() {
            // given
            String tooManyNumber = "1,2,3,4,5,6,7";
            String duplicatedNumber = "1,1,1,1,1,1";
            String invalidRangeNumber = "1,2,3,4,5,100";
            String notNumber = "a";
            String duplicatedWithLottoNumber = "1";

            Supplier<String> inputFunction = mock(Supplier.class);
            when(inputFunction.get())
                    .thenReturn(tooManyNumber)
                    .thenReturn(duplicatedNumber)
                    .thenReturn(invalidRangeNumber)
                    .thenReturn(notNumber)
                    .thenReturn("1,2,3,4,5,6")
                    .thenReturn(duplicatedWithLottoNumber)
                    .thenReturn(notNumber)
                    .thenReturn("7");

            UserInputAdapter adapter = new UserInputAdapter(inputFunction);

            // when
            LottoAnswer lottoAnswer = adapter.getLottoAnswer();

            // then
            assertThat(lottoAnswer.lottoNumbers()).contains(1, 2, 3, 4, 5, 6);
            assertThat(lottoAnswer.lottoBonusNumber()).isEqualTo(7);
        }
    }
}
