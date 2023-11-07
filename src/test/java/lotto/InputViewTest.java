package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    LottoController lottoController = new LottoController();

    @DisplayName("당첨 번호의 크기가 6이 아니면 에러가 발생해야 한다.")
    @Test
    void checkErrorOccurWinningNumbersSize() {
        String[] winNumber = {"1", "2", "3", "4"};
        assertThatThrownBy(() -> lottoController.inputWinNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
