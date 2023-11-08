package lotto;

import lotto.Model.Lotto;
import lotto.Model.UserLottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.View.ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR;
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
    @DisplayName("올바르지 않은 금액을 입력하면 예외가 발생한다.")
    void failed() {
        assertThatThrownBy(() -> new UserLottoAmount("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_DIVISIBLE_NUMBER_ERROR);
    }

    @Test
    @DisplayName("구매한 로또 티켓 장수가 올바르게 표시되어야 한다.")
    void calculateLottoCount() {
        UserLottoAmount amount = new UserLottoAmount("3000");
        assertThat(amount.CalcLottoCount()).isEqualTo(3);
    }
}