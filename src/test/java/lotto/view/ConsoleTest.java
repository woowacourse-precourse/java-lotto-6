package lotto.view;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ConsoleTest {

    @Test
    void 당첨_번호를_입력_받을때_입력값이_null이면_예외를_발생한다() {
        // given
        Input fakeInput = () -> null;
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when, then
        assertThatThrownBy(console::readWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호를_입력_받을때_구분자_외_숫자가_아닌_값이_있으면_예외를_발생한다() {
        // given
        Input fakeInput = () -> "a,1,3,4";
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when, then
        assertThatThrownBy(console::readWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 당첨_번호를_입력받으면_당첨_번호를_리스트로_반환한다() {
        // given
        Input fakeInput = () -> "1,2,3,4,5,6";
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when
        List<Integer> winningNumbers = console.readWinningNumbers();

        // then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스_번호를_입력_받았을때_null이면_예외를_발생한다() {
        // given
        Input fakeInput = () -> null;
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when, then
        assertThatThrownBy(console::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "보너스 번호 입력 값: \"{0}\"")
    @ValueSource(strings = {"a", " ", "", "   "})
    void 보너스_번호를_입력_받았을때_숫자이외의_값을_입력받았을_경우_예외를_발생한다(String inputValue) {
        // given
        Input fakeInput = () -> inputValue;
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when, then
        assertThatThrownBy(console::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호를_입력_받았을때_0이상의_정수_값이_아닌경우_예외를_발생한다() {
        // given
        Input fakeInput = () -> "-1";
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when, then
        assertThatThrownBy(console::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "보너스 번호 입력 값: \"{0}\"")
    @ValueSource(strings = {"1", "0", "01", "100", "1000", "10000", "100000", "1000000"})
    void 보너스_번호를_입력_받았을때_0이상의_정수이면_예외를_발생하지_않는다(String inputValue) {
        // given
        Input fakeInput = () -> inputValue;
        Console console = new Console(fakeInput, new PrintStreamOutputView());

        // when
        int bonusNumber = console.readBonusNumber();

        // then
        assertThat(bonusNumber).isEqualTo(Integer.parseInt(inputValue));
    }

}
