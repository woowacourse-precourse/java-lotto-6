package lotto;

import lotto.domain.Amount;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액_입력테스트() {
        Amount amount = new Amount(8000);
        assertThat(8000).isEqualTo(amount.getAmount());
        assertThat(8).isEqualTo(amount.getCount());
    }

    @Test
    void 구입금액_예외처리_테스트() {
        assertThatThrownBy(() -> new Amount(8800))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_ERROR_MESSAGE);
    }

    @Test
    void 당첨번호_입력테스트() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(winningNumber.getWinningNumber());
    }

    @Test
    void 당첨번호_예외처리_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_LENGTH_ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 55, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_ERROR_MESSAGE);
    }
}