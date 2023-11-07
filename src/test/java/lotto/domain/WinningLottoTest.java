package lotto.domain;

import static org.assertj.core.api.Assertions.*;

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
                .hasMessage("로또 번호의 개수는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 개수는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 3), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외를 발생한다.")
    @Test
    void duplicateBonusAndWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
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
                .hasMessage("로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }
}