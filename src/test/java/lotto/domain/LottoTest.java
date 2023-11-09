package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.exception.errorcode.InputErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.fixture.LottoFixture.SECOND;
import static lotto.fixture.LottoFixture.WINNING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 범위가 벗어나면 예외가 발생한다")
    @Test
    void createLottoByInvalidRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("파라미터로 전달된 로또 번호는 오름차순 정렬된다.")
    @Test
    void createLottoGetSortedNumbers() {
        final Lotto lotto = new Lotto(List.of(6, 5, 4, 1, 2, 3));
        for (int i = 0; i < 6; i++) {
            final int actual = lotto.getNumberFromIndex(i);
            final int expect = i + 1;

            assertThat(actual).isEqualTo(expect);
        }
    }

    @DisplayName("로또 일치 개수를 반환한다.")
    @Test
    void getMatchedCount() {
        final Lotto winningLotto = WINNING.생성();
        final Lotto secondLotto = SECOND.생성();

        final int actual = winningLotto.getMatchedCount(secondLotto);
        final int expect = 5;

        assertThat(actual).isEqualTo(expect);
    }
}