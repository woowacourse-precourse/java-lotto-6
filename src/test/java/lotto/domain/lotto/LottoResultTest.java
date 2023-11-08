package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("로또 결과를 정상적으로 생성한다.")
    void 로또_결과를_정상적으로_생성한다() {
        // given
        var matchCount = 3;
        var hasBonusNumber = true;

        // when
        var lottoResult = LottoResult.of(matchCount, hasBonusNumber);

        // then
        assertThat(lottoResult).isEqualTo(LottoResult.of(matchCount, hasBonusNumber));
        assertThat(lottoResult.matchCount()).isEqualTo(matchCount);
        assertThat(lottoResult.hasBonusNumber()).isEqualTo(hasBonusNumber);
    }

    @Test
    @DisplayName("두 로또 결과가 같으면 true를 반환한다.")
    void 두_로또_결과가_같으면_true를_반환한다() {
        // given
        var lottoResult = LottoResult.of(3, false);
        var sameLottoResult = LottoResult.of(3, false);

        // when & then
        assertThat(lottoResult.equals(sameLottoResult)).isTrue();
    }

    @Test
    @DisplayName("두 로또 결과가 다르면 false를 반환한다.")
    void 두_로또_결과가_다르면_false를_반환한다() {
        // given
        var lottoResult = LottoResult.of(3, false);
        var differentLottoResult = LottoResult.of(4, false);

        // when & then
        assertThat(lottoResult.equals(differentLottoResult)).isFalse();
    }

    @Test
    @DisplayName("두 로또 결과가 같으면 같은 hashCode를 반환한다.")
    void 두_로또_결과가_같으면_같은_hashCode를_반환한다() {
        // given
        var lottoResult = LottoResult.of(3, false);
        var sameLottoResult = LottoResult.of(3, false);

        // when & then
        assertThat(lottoResult.hashCode()).isEqualTo(sameLottoResult.hashCode());
    }

    @Test
    @DisplayName("두 로또 결과가 다르면 다른 hashCode를 반환한다.")
    void 두_로또_결과가_다르면_다른_hashCode를_반환한다() {
        // given
        var lottoResult = LottoResult.of(3, false);
        var differentLottoResult = LottoResult.of(4, false);

        // when & then
        assertThat(lottoResult.hashCode()).isNotEqualTo(differentLottoResult.hashCode());
    }
}
