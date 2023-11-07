package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(LottoNumbers.from(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // given
        final List<Integer> overSizeNumbers = List.of(1, 2, 3, 4, 5, 6, 7); // 개수가 6개 초과

        // when & then
        assertThatThrownBy(() -> new Lotto(LottoNumbers.from(overSizeNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 생성 시 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // given
        final List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복된 숫자 포함

        // when & then
        assertThatThrownBy(() -> new Lotto(LottoNumbers.from(duplicatedNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일치하는_번호_개수_반환() {
        // given
        final LottoNumbers otherLottoNumbers = LottoNumbers.from(List.of(4, 5, 6, 7, 8, 9)); // 3개 일치

        // when
        final int matchCount = lotto.countMatch(otherLottoNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 보너스_번호_일치_여부_반환() {
        // given
        final LottoNumber bonusNumber = new LottoNumber(7);

        // when
        final boolean bonusNumberMatch = lotto.checkBonusNumber(bonusNumber);

        // then
        assertThat(bonusNumberMatch).isFalse();
    }
}
