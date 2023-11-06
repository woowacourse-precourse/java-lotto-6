package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 갯수가 맞지 않습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 있습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void 범위에_맞지_않은_숫자가_있는_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 범위에 맞지 않은 숫자가 있습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3"})
    void 같은_숫자가_몇개가_있는지_계산(int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        assertThat(lotto.equalsNumberCount(winningNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "7,false"})
    void 지정한_숫자가_포함되어_있는지_확인(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(number)).isEqualTo(expected);
    }
}