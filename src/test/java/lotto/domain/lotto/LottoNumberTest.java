package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 정상적으로 생성된다.")
    void 로또_번호가_정상적으로_생성된다() {
        // given
        var number = 1;

        // when
        var lottoNumber = LottoNumber.of(number);

        // then
        assertThat(lottoNumber).isNotNull()
                .isInstanceOf(LottoNumber.class);
    }

    @Test
    @DisplayName("로또 번호가 1보다 작을 경우 예외를 반환한다.")
    void 로또_번호가_1보다_작을_경우_예외를_반환한다() {
        // given
        var number = 0;

        // when & then
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 45보다 클 경우 예외를 반환한다.")
    void 로또_번호가_45보다_클_경우_예외를_반환한다() {
        // given
        var number = 46;

        // when & then
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두 로또 번호가 같을 경우 true를 반환한다.")
    void 두_로또_번호가_같을_경우_true를_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);
        var sameLottoNumber = LottoNumber.of(1);

        // when & then
        assertThat(lottoNumber.equals(sameLottoNumber)).isTrue();
    }

    @Test
    @DisplayName("두 로또 번호가 다를 경우 false를 반환한다.")
    void 두_로또_번호가_다를_경우_false를_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);
        var differentLottoNumber = LottoNumber.of(2);

        // when & then
        assertThat(lottoNumber.equals(differentLottoNumber)).isFalse();
    }

    @Test
    @DisplayName("두 로또 번호가 같은 경우 같은 hashCode를 반환한다.")
    void 두_로또_번호가_같은_경우_같은_hashCode를_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);
        var sameLottoNumber = LottoNumber.of(1);

        // when & then
        assertThat(lottoNumber.hashCode())
                .isEqualTo(sameLottoNumber.hashCode());
    }

    @Test
    @DisplayName("두 로또 번호가 다른 경우 다른 hashCode를 반환한다.")
    void 두_로또_번호가_다른_경우_다른_hashCode를_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);
        var differentLottoNumber = LottoNumber.of(2);

        // when & then
        assertThat(lottoNumber.hashCode())
                .isNotEqualTo(differentLottoNumber.hashCode());
    }

    @Test
    @DisplayName("두 로또 번호를 비교할 때 비교 대상이 작을 경우 음수를 반환한다.")
    void 두_로또_번호를_비교할_때_비교_대상이_작을_경우_음수를_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);
        var differentLottoNumber = LottoNumber.of(2);

        // when & then
        assertThat(lottoNumber.compareTo(differentLottoNumber))
                .isLessThan(0);
    }

    @Test
    @DisplayName("두 로또 번호를 비교할 때 비교 대상이 클 경우 양수를 반환한다.")
    void 두_로또_번호를_비교할_때_비교_대상이_클_경우_양수를_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(2);
        var differentLottoNumber = LottoNumber.of(1);

        // when & then
        assertThat(lottoNumber.compareTo(differentLottoNumber))
                .isGreaterThan(0);
    }

    @Test
    @DisplayName("두 로또 번호를 비교할 때 같은 경우 0을 반환한다.")
    void 두_로또_번호를_비교할_때_같은_경우_0을_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);
        var sameLottoNumber = LottoNumber.of(1);

        // when & then
        assertThat(lottoNumber.compareTo(sameLottoNumber))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("로또 번호를 문자열로 변환할 경우 해당 번호 문자열을 반환한다.")
    void 로또_번호를_문자열로_변환할_경우_해당_번호_문자열을_반환한다() {
        // given
        var lottoNumber = LottoNumber.of(1);

        // when & then
        assertThat(lottoNumber.toString())
                .isEqualTo("1");
    }
}
