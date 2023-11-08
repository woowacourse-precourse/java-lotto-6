package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByNumberDuplicatedWithLottoNumbers() {
        // given
        int bonusNumber = 1;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoController lottoController = new LottoController(new InputView(), new OutputView());

        // when & then
        assertThatThrownBy(() -> lottoController.checkBonusNumberDuplicatedWithWinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
