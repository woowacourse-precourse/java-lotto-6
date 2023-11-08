package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
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

    @DisplayName("정렬되지 않은 로또인 경우 정렬하고 생성한다.")
    @Test
    void should_SortNumbers_When_NotSorted() {
        Lotto lotto = new Lotto(List.of(5, 1, 14, 8, 15, 2));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 5, 8, 14, 15));
    }

    @DisplayName("범위를 벗어난 숫자를 가진경우 예외가 발생한다.")
    @Test
    void should_ThrowException_When_HasNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(50, 51, 52, 53, 54, 55)))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("불변객체를 조작하려는 경우 예외가 발생한다.")
    @Test
    void should_ThrowException_When_TryToManipulate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.getNumbers().add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("매칭되는 숫자의 개수를 반환한다.")
    @Test
    void should_CountMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        assertThat(lotto.countMatches(winningLotto)).isEqualTo(4);
    }

    @DisplayName("보너스번호 유무를 판별한다.")
    @Test
    void should_ContainBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6, new Lotto(List.of(2, 3, 4, 5, 7, 8)));
        assertThat(lotto.contains(bonusNumber)).isTrue();
    }

    @DisplayName("올바른 로또번호를 갖는다.")
    @Test
    void should_HaveRightNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}