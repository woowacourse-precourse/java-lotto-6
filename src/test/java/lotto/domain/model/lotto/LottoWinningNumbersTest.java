package lotto.domain.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoWinningNumbersTest {

    @DisplayName("보너스 번호와 당첨번호에 중복되는 숫자가 있을 시 예외가 발생한다.")
    @Test
    void createLottoWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.from(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호와 당첨번호에 중복되는 숫자가 없을시 생성에 성공한다.")
    @Test
    void createLottoWinningNumbersSuccessfully() {
        Lotto winningNumber = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumber, bonusNumber);

        assertThat(lottoWinningNumbers).isNotNull();
    }
}