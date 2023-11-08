package lotto.view.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.view.input.reader.ConsoleReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 구입 입력 뷰")
class LottoPurchaseInputViewTest {
    private LottoPurchaseInputView lottoPurchaseInputView;
    private ConsoleReader mockConsoleReader;

    @BeforeEach
    void setUp() {
        mockConsoleReader = mock(ConsoleReader.class);
        lottoPurchaseInputView = new LottoPurchaseInputView(mockConsoleReader);
    }

    @Test
    @DisplayName("로또 구입 금액을 입력합니다.")
    void Should_Input_Lotto_Purchase_Amount_When_Read() {
        //given
        final String expectedReadString = "1000";
        when(mockConsoleReader.read()).thenReturn(expectedReadString);

        final LottoPurchaseAmount expected = new LottoPurchaseAmount(1000);

        //when
        final LottoPurchaseAmount actual = lottoPurchaseInputView.readLottoPurchaseAmount();

        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("숫자 형식이 아니면 IllegalArgumentException 예외를 발생시킵니다.")
    void Should_LottoException_Thrown_When_Invalid_Number_Format_Read() {
        //given
        final String expectedReadString = "1000j";
        when(mockConsoleReader.read()).thenReturn(expectedReadString);

        //when, then
        assertThatThrownBy(() -> lottoPurchaseInputView.readLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력이 가능합니다.");
    }
}
