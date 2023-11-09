package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.lottonumbersexception.LottoNumbersInputException;
import lotto.exception.lottonumbersexception.NumbersErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @ValueSource(ints = {8, 21, 43})
    @ParameterizedTest(name = "보너스 번호: {0}, 당첨 번호: [8, 21, 23, 41, 42, 43] ")
    void createWinningLottoByDuplicatedNumber(int number) {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber(number);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(LottoNumbersInputException.class)
                .hasMessage(NumbersErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않은 정상적인 결과.")
    @ValueSource(ints = {1, 38, 45})
    @ParameterizedTest(name = "보너스 번호: {0}, 당첨 번호: [8, 21, 23, 41, 42, 43] ")
    void createWinningLotto(int number) {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber(number);

        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // then
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

}