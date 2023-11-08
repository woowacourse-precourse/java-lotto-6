package lotto;

import lotto.domain.Lotto;
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

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("로또 번호 중 하나가 0으로 주어진 경우 예외 처리 테스트")
    void createLottoByOutOfStartRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호들 중에서 45를 넘기는 번호가 주어진 경우 예외 처리 테스트")
    void createLottoByOutOfEndRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호와 중복되는 번호를 가지고 있으면 true 반환한다.")
    void containsDuplicateNumber() {
        //given
        int number = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        boolean result = lotto.hasNumber(number);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("로또 번호와 중복되는 번호 가지고 있지 않으면 false 반환한다.")
    void containsNotDuplicateNumber() {
        //given
        int number = 45;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        boolean result = lotto.hasNumber(number);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("로또에 저장된 번호들을 형식에 맞춰 문자열로 반환하는 기능 테스트")
    void getFormalizedNumbersTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        String result = lotto.getFormalizedNumbers();
        //then
        assertThat(result).isEqualTo("1, 2, 3, 4, 5, 6");
    }
}