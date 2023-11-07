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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void throw_exception_when_bonus_number_duplicate(int bonusNumber) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(new Lotto(numbers), new LottoNumber(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLottoException.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @DisplayName("비교하는 로또와 보너스 번호가 일치할 때 참을 반환한다.")
    @Test
    void true_when_bonus_number_matches() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7)
        );
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        boolean matchesBonusNumber = winningLotto.matchesBonusNumber(lotto);

        // then
        assertThat(matchesBonusNumber).isTrue();
    }

    @DisplayName("비교하는 로또가 2등일 때 보너스 번호가 일치하지 않으면 거짓을 반환한다.")
    @Test
    void false_when_second_rank_lotto_does_not_match_bonus_number() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7)
        );
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        // when
        boolean matchesBonusNumber = winningLotto.matchesBonusNumber(lotto);

        // then
        assertThat(matchesBonusNumber).isFalse();
    }

    @DisplayName("비교하는 로또가 2등이 아닐 때 때 보너스 번호가 일치해도 거짓을 반환한다.")
    @Test
    void false_when_not_second_rank_lotto_does_not_match_bonus_number() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7)
        );
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // when
        boolean matchesBonusNumber = winningLotto.matchesBonusNumber(lotto);

        // then
        assertThat(matchesBonusNumber).isFalse();
    }
}
