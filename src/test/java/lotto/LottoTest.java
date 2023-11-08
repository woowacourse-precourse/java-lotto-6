package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
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

    @DisplayName("로또 번호는 오름차순 정렬로 되어있다.")
    @Test
    void createLottoSortedASC() {
        LottoMachine lottoMachine = new LottoMachine(1000);
        Lotto lotto = new Lotto(lottoMachine.generateLotto());

        assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("보너스 번호가 당첨 번호에 중복되어 있으면 예외가 발생한다.")
    @Test
    void validateContainsBonusInLotto() {
        assertThatThrownBy(
                () -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).validateContainsBonusInLotto(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}