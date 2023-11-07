package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 미만이면 예외가 발생한다")
    @Test
    void createLottoByUnderNonNaturalNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45 초과면 예외가 발생한다")
    @Test
    void createLottoByOver45Number() {
        assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("match 테스트 - MATCH_NONE")
    @Test
    void matchTest_MATCH_NONE() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var actual = lotto.match(List.of(7, 8, 9, 10, 11, 12), 13);
        assertThat(actual).isEqualTo(LottoMatchType.MATCH_NONE);
    }

    @DisplayName("match 테스트 - MATCH_THREE")
    @Test
    void matchTest_MATCH_THREE() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var actual = lotto.match(List.of(1, 2, 3, 7, 8, 9), 4);
        assertThat(actual).isEqualTo(LottoMatchType.MATCH_THREE);
    }

    @DisplayName("match 테스트 - MATCH_FOUR")
    @Test
    void matchTest_MATCH_FOUR() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var actual = lotto.match(List.of(1, 2, 3, 4, 7, 8), 5);
        assertThat(actual).isEqualTo(LottoMatchType.MATCH_FOUR);
    }

    @DisplayName("match 테스트 - MATCH_FIVE")
    @Test
    void matchTest_MATCH_FIVE() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var actual = lotto.match(List.of(1, 2, 3, 4, 5, 7), 8);
        assertThat(actual).isEqualTo(LottoMatchType.MATCH_FIVE);
    }

    @DisplayName("match 테스트 - MATCH_FIVE_BONUS")
    @Test
    void matchTest_MATCH_FIVE_BONUS() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var actual = lotto.match(List.of(1, 2, 3, 4, 5, 7), 6);
        assertThat(actual).isEqualTo(LottoMatchType.MATCH_FIVE_BONUS);
    }

    @DisplayName("match 테스트 - MATCH_SIX")
    @Test
    void matchTest_MATCH_SIX_BONUS() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var actual = lotto.match(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(actual).isEqualTo(LottoMatchType.MATCH_SIX);
    }

}