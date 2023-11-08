package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    public static WinningNumbers winningNumbers;
    public static Lotto lottoContainsBonusNumber;
    public static Lotto lottoNotContainsBonusNumber;

    @BeforeAll
    static void setUp() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoContainsBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoNotContainsBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호 입력 시 보너스 번호가 로또 번호에 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 로또 번호가 들어있을 경우 true를 반환한다.")
    @Test
    void containsLottoNumber() {
        assertThat(winningNumbers.containsLottoNumber(3)).isTrue();
    }

    @DisplayName("당첨 번호에 로또 번호가 들어있지 않을 경우 false를 반환한다.")
    @Test
    void notContainsLottoNumber() {
        assertThat(winningNumbers.containsLottoNumber(7)).isFalse();
    }

    @DisplayName("로또 번호에 보너스 번호가 있을 경우 true를 반환한다.")
    @Test
    void matchBonusNumbers() {
        assertThat(winningNumbers.matchBonusNumbers(lottoContainsBonusNumber.getNumbers())).isTrue();
    }

    @DisplayName("로또 번호에 보너스 번호가 있지 않을 경우 false를 반환한다.")
    @Test
    void notMatchBonusNumbers() {
        assertThat(winningNumbers.matchBonusNumbers(lottoNotContainsBonusNumber.getNumbers())).isFalse();
    }
}