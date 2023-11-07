package lotto.view;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

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

}
