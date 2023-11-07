package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("[EXCEPTION]로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
    }

    @DisplayName("[EXCEPTION]로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
    }

    @DisplayName("[EXCEPTION]로또 번호에 1 미만의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByLessThanMinNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("[EXCEPTION]로또 번호에 45 초과의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByGreaterThanMaxNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("[SUCCESS]로또 번호를 오름차순 정렬한 문자열을 가져온다.")
    @Test
    void getSortedLottoNumber() {
        // given
        Lotto lotto = new Lotto(List.of(43, 21, 23, 42, 41, 8));

        // when
        String lottoNumber = lotto.getSortedNumbers();

        // then
        assertThat(lottoNumber)
                .isEqualTo("[8, 21, 23, 41, 42, 43]");
    }

    @DisplayName("[SUCCESS]로또 번호에 특정 번호가 포함되어 있으면 true를 반환한다.")
    @Test
    void checkLottoContainSpecificNumber() {
        // given
        Lotto lotto = new Lotto(List.of(43, 21, 23, 42, 41, 8));

        // when, then
        assertThat(lotto.isContainNumber(43))
                .isEqualTo(true);
    }

}