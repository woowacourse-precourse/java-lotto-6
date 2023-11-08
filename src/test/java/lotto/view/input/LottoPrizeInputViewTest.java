package lotto.view.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.prize.PrizeNumberType;
import lotto.view.input.reader.ConsoleReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 번호 입력 뷰")
class LottoPrizeInputViewTest {
    private LottoPrizeInputView lottoPrizeInputView;
    private ConsoleReader mockConsoleReader;

    @BeforeEach
    void setUp() {
        mockConsoleReader = mock(ConsoleReader.class);
        lottoPrizeInputView = new LottoPrizeInputView(mockConsoleReader);
    }

    @Test
    @DisplayName("당첨 번호를 입력합니다.")
    void Should_Input_Prize_Numbers_When_Read() {
        //given
        final String expectedReadString = "1,2,3,4,5,6";
        when(mockConsoleReader.read()).thenReturn(expectedReadString);

        final List<PrizeNumber> expected = List.of(
                new PrizeNumber(1),
                new PrizeNumber(2),
                new PrizeNumber(3),
                new PrizeNumber(4),
                new PrizeNumber(5),
                new PrizeNumber(6)
        );

        //when
        final List<PrizeNumber> actual = lottoPrizeInputView.readPrizeNumbers();

        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("당첨 번호 입력 시 숫자 형식이 아니면 IllegalArgumentException 예외를 발생시킵니다.")
    void Should_LottoException_Thrown_When_Prize_Numbers_With_Invalid_Number_Format_Read() {
        //given
        final String expectedReadString = "a,b,c,d,e,f";
        when(mockConsoleReader.read()).thenReturn(expectedReadString);

        //when, then
        assertThatThrownBy(() -> lottoPrizeInputView.readPrizeNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호를 입력합니다.")
    void Should_Input_Bonus_Number_When_Read() {
        //given
        final String expectedReadString = "7";
        when(mockConsoleReader.read()).thenReturn(expectedReadString);

        final PrizeNumber expected = new PrizeNumber(7, PrizeNumberType.BONUS);

        //when
        final PrizeNumber actual = lottoPrizeInputView.readBonusNumber();

        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("보너스 번호 입력 시 숫자 형식이 아니면 IllegalArgumentException 예외를 발생시킵니다.")
    void Should_LottoException_Thrown_When_Bonus_Number_With_Invalid_Number_Format_Read() {
        //given
        final String expectedReadString = "a";
        when(mockConsoleReader.read()).thenReturn(expectedReadString);

        //when, then
        assertThatThrownBy(() -> lottoPrizeInputView.readBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력이 가능합니다.");
    }
}
