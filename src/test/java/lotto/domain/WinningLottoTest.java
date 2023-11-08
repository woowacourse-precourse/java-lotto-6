package lotto.domain;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 3), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외를 발생한다.")
    @Test
    void duplicateBonusAndWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호와 당첨 번호가 서로 다르면 정상 생성한다.")
    @Test
    void noDuplicateBonusAndWinningNumbers() {
        assertThatNoException()
                .isThrownBy(() -> new WinningLotto(lottoNumbers, 7));
    }

    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 46})
    void bonusNumberNotInRange1To45(int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호와 구입한 로또를 비교하고 당첨 등수를 반환한다.")
    @Test
    void calculateRank() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        Rank rank = winningLotto.calculateRank(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}