package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
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

    @DisplayName("로또 번호가 1 ~ 45 범위를 초과하면 예외가 발생한다.")
    @Test
    void createLottoByExcessNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 정상적으로 생성된다.")
    @Test
    void createLottoSucceed() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        Lotto lotto = new Lotto(numbers);
        //then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 번호가 오름차순 정렬되어 생성된다.")
    @Test
    void createLottoSorted() {
        //given
        List<Integer> numbers = List.of(6, 5, 4, 3, 2, 1);
        //when
        Lotto lotto = new Lotto(numbers);
        //then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또간의 일치하는 숫자의 개수를 반환한다.")
    @Test
    void matchNumberCount() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        //when
        int matchNumberCount = lotto.matchNumberCount(winningLotto);
        //then
        assertThat(matchNumberCount).isEqualTo(5);
    }

    @DisplayName("특정 번호가 존재하면 true를 반환한다.")
    @Test
    void containWithExistNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Number number = Number.of(1);
        //when
        boolean isContainNumber = lotto.contain(number);
        //then
        assertThat(isContainNumber).isTrue();
    }

    @DisplayName("특정 번호가 존재하지 않으면 false를 반환한다.")
    @Test
    void containWithNotExistNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Number number = Number.of(7);
        //when
        boolean isContainNumber = lotto.contain(number);
        //then
        assertThat(isContainNumber).isFalse();
    }
}