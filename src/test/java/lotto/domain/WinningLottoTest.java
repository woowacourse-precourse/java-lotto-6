package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.Lotto;
import lotto.exception.WinningLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[단위 테스트] 당첨 로또")
class WinningLottoTest {

    @DisplayName("정상 상황일 때 당첨 로또가 생성된다.")
    @Test
    void create_winning_lotto() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), new LottoNumber(bonusNumber));

        // then
        assertAll(
                () -> assertThatCode(() ->
                        new WinningLotto(new Lotto(numbers), new LottoNumber(bonusNumber))).doesNotThrowAnyException(),

                () -> assertThat(winningLotto).isNotNull()
        );
    }

    @DisplayName("당첨 로또의 로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void throw_exception_when_bonus_number_duplicate() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> new WinningLotto(new Lotto(numbers), new LottoNumber(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLottoException.DUPLICATE_BONUS_NUMBER.getMessage());
    }
}
