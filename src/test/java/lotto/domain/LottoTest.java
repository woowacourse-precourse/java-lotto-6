package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개 초과하면 예외가 발생한다.")
    void createLottoByOverSize() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
    }

    @DisplayName("로또 번호의 개수가 6개이면 예외가 발생하지 않는다.")
    @Test
    void createLottoBySize() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when

        // then
        assertThatCode(() -> new Lotto(lottoNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 없으면 예외가 발생하지 않는다.")
    @Test
    void createLottoByNonDuplicatedNumber() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when

        // then
        assertThatCode(() -> new Lotto(lottoNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 1에서 45 사이의 숫자보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 46);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("로또 번호에 1에서 45 사이의 숫자보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 0);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("로또 번호에 1에서 45 사이의 숫자만 있으면 예외가 발생하지 않는다.")
    @Test
    void createLottoByValidRange() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 45);
        // when

        // then
        assertThatCode(() -> new Lotto(lottoNumbers))
                .doesNotThrowAnyException();
    }
}