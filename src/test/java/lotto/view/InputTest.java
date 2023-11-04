package lotto.view;

import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class InputTest {

    MockedStatic<Console> console;

    @BeforeEach
    void beforeEach() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void afterEach() {
        console.close();
    }

    @Test
    @DisplayName("금액입력 성공 테스트")
    void amountInputSuccessTest() {
        // given
        String amount = "8000";
        Input amountInput = new AmountInput();

        // when
        console.when(Console::readLine).thenReturn(amount);
        String result = amountInput.readLine();

        // then
        Assertions.assertThat(result).isEqualTo(amount);
    }

    @Test
    @DisplayName("당첨번호 입력 성공 테스트")
    void lottoInputSuccessTest() {
        // given
        String amount = "1,2,3,4,5,6";
        Input lottoAnswerInput = new LottoAnswerInput();

        // when
        console.when(Console::readLine).thenReturn(amount);
        String result = lottoAnswerInput.readLine();

        // then
        Assertions.assertThat(result).isEqualTo(amount);
    }

    @Test
    @DisplayName("보너스번호 입력 성공 테스트")
    void numberInputSuccessTest() {
        // given
        String amount = "1";
        Input numberInput = new BonusNumberInput();

        // when
        console.when(Console::readLine).thenReturn(amount);
        String result = numberInput.readLine();

        // then
        Assertions.assertThat(result).isEqualTo(amount);
    }
}