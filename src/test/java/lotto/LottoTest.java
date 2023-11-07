package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("로또 번호 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByLiteral() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 77, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 로또 번호중에 중복되면 예외를 발생시킨다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new WinningLotto(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // 아래에 추가 테스트 작성 가능
}