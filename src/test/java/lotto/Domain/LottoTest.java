package lotto.Domain;

import lotto.Domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성시 빈 리스트나 NULL이 들어오면 예외가 발생한다.")
    @Test
    void createLottoByEmptyList() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(null));
    }

    @DisplayName("보너스 번호에 빈 문자열이나 NULL이 들어오면 예외가 발생한다.")
    @Test
    void setBonusNumberByEmptyString() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 숫자가 아닌 문자가 들어오면 예외가 발생한다.")
    @Test
    void setBonusNumberByNotNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1~45가 아닌 숫자가 들어오면 예외가 발생한다.")
    @Test
    void setBonusNumberByInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 로또 번호가 중복되면 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정상적으로 생성된다.")
    @Test
    void createLotto() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Lotto.class);
    }



}