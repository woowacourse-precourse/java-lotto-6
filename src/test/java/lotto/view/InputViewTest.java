package lotto.view;

import static lotto.exception.LottoErrorCode.BLANK_INPUT;
import static lotto.exception.LottoErrorCode.NOT_INTEGER_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.exception.LottoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}