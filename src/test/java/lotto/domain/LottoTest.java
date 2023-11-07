package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호중 1~45 사이의 값이 아닌게 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotInRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, -1, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("보너스 로또 번호가 1~45 사이의 값이 아니면 예외가 발생한다.")
    @Test
    void inputBonusNumberByValidNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).inputBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).inputBonusNumber(47))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).inputBonusNumber(-10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호중 보너스 로또 번호와 중복된 값이 있다면 예외가 발생한다.")
    @Test
    void inputBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(()->new Lotto(List.of(1,2,3,4,5,6)).inputBonusNumber(2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Lotto(List.of(1,2,3,4,5,6)).inputBonusNumber(3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Lotto(List.of(1,2,3,4,5,6)).inputBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}