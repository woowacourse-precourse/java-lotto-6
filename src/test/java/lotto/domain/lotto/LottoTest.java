package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또가 정상적으로 생성된다.")
    void 로또가_정상적으로_생성된다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        var lotto = new Lotto(numbers);

        // then
        assertThat(lotto).isNotNull().isInstanceOf(Lotto.class);
        assertThat(lotto.numbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 비어있으면 예외를 반환한다.")
    void 로또_번호가_비어있으면_예외를_반환한다() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 보다 적으면 예외를 반환한다.")
    void 로또_번호의_개수가_6개_보다_적으면_예외를_반환한다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 보다 많으면 예외를 반환한다.")
    void 로또_번호의_개수가_6개_보다_많으면_예외를_반환한다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외를 반환한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외를_반환한다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 특정 번호가 포함되어 있으면 true를 반환한다.")
    void 로또_번호에_특정_번호가_포함되어_있으면_true를_반환한다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5, 6);
        var lotto = new Lotto(numbers);

        // when
        var contains = lotto.contains(LottoNumber.of(1));

        // then
        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("로또 번호에 특정 번호가 포함되어 있지 않으면 false를 반환한다.")
    void 로또_번호에_특정_번호가_포함되어_있지_않으면_false를_반환한다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5, 6);
        var lotto = new Lotto(numbers);

        // when
        var contains = lotto.contains(LottoNumber.of(7));

        // then
        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("로또 번호를 정상적으로 반환한다.")
    void 로또_번호를_반환한다() {
        // given
        var numbers = List.of(1, 2, 3, 4, 5, 6);
        var lotto = new Lotto(numbers);

        // when
        var lottoNumbers = lotto.numbers();

        // then
        assertThat(lottoNumbers)
                .hasSize(6)
                .containsExactly(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6));
    }
}
