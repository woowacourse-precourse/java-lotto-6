package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 외의 숫자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void validateLottoNumbers_numberNotInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 출력 형식 테스트")
    @Test
    void lottoPrintFormat_test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        assertThat(lotto.lottoPrintFormat()).isEqualTo("[1, 2, 3, 4, 5, 15]");
    }

    @DisplayName("5등 당첨")
    @Test
    void compareWithWinNumbers_THREE() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        assertThat(lotto.compareWithWinNumbers(List.of(1, 2, 3, 24, 25, 35), 40)).isEqualTo(3);
    }

    @DisplayName("4등 당첨")
    @Test
    void compareWithWinNumbers_FOUR() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        assertThat(lotto.compareWithWinNumbers(List.of(1, 2, 3, 24, 25, 35), 40)).isEqualTo(3);
    }

    @DisplayName("3등 당첨")
    @Test
    void compareWithWinNumbers_FIVE() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        assertThat(lotto.compareWithWinNumbers(List.of(1, 2, 3, 24, 25, 35), 40)).isEqualTo(3);
    }

    @DisplayName("2등 당첨")
    @Test
    void compareWithWinNumbers_FIVE_AND_BONUS() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        assertThat(lotto.compareWithWinNumbers(List.of(1, 2, 3, 4, 25, 15), 5)).isEqualTo(7);
    }

    @DisplayName("1등 당첨")
    @Test
    void compareWithWinNumbers_SIX() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        assertThat(lotto.compareWithWinNumbers(List.of(1, 2, 3, 4, 5, 15), 40)).isEqualTo(6);
    }
}