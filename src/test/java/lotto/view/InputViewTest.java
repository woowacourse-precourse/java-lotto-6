package lotto.view;

import static lotto.exception.LottoErrorCode.BLANK_INPUT;
import static lotto.exception.LottoErrorCode.NOT_INTEGER_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    void 구매_가격을_입력받는다() {
        final String input = "1000";
        command(input);

        int purchaseAmount = InputView.inputLottoPurchaseAmount();

        assertThat(purchaseAmount).isEqualTo(1000);
    }

    @Test
    void 구매_가격이_숫자가_아니라면_예외를_던진다() {
        final String input = "poby";
        command(input);

        assertThatThrownBy(InputView::inputLottoPurchaseAmount)
            .isInstanceOf(LottoException.class)
            .hasMessageContaining(NOT_INTEGER_INPUT.getMessage());
    }

    @Test
    void 구매_가격이_빈값이라면_예외를_던진다() {
        final String input = "\n";
        command(input);

        assertThatThrownBy(InputView::inputLottoPurchaseAmount)
            .isInstanceOf(LottoException.class)
            .hasMessageContaining(BLANK_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    void 당첨_번호를_정상적으로_입력받는다(final String input) {
        command(input);

        final List<Integer> winningNumber = InputView.inputLottoWinningNumbers();

        assertThat(winningNumber).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,poby", "1,2,3,,5,6"})
    void 당첨_번호에_숫자가_값이_포함되지_않는다면_예외를_던진다(final String input) {
        command(input);

        assertThatThrownBy(InputView::inputLottoPurchaseAmount)
            .isInstanceOf(LottoException.class)
            .hasMessageContaining(NOT_INTEGER_INPUT.getMessage());

    }

    @Test
    void 보너스_번호를_정상적으로_입력받는다() {
        final String input = "5";
        command(input);

        final int bonusNumber = InputView.inputLottoBonusNumber();

        assertThat(bonusNumber).isEqualTo(5);
    }

    @Test
    void 보너스_번호가_숫자가_아니라면_예외를_던진다() {
        final String input = "poby";
        command(input);

        assertThatThrownBy(InputView::inputLottoBonusNumber)
            .isInstanceOf(LottoException.class)
            .hasMessageContaining(NOT_INTEGER_INPUT.getMessage());
    }

    @Test
    void 보너스_번호가_빈값이라면_예외를_던진다() {
        final String input = "\n";
        command(input);

        assertThatThrownBy(InputView::inputLottoBonusNumber)
            .isInstanceOf(LottoException.class)
            .hasMessageContaining(BLANK_INPUT.getMessage());
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}