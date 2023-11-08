package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThatThrownBy(() -> new Lotto(List.of(2, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에서 당첨번호가 포함되어 있는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또에서_당첨번호가_포함되어_있는지_테스트(int winningNumber) {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.containLottoNumber(winningNumber)).isTrue();
    }

    @DisplayName("로또에서 당첨갯수가 몇개인지 테스트")
    @Test
    void 로또에서_당첨갯수가_몇개인지_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        assertThat(lotto.matchCount(winningLotto)).isEqualTo(6);
    }
}