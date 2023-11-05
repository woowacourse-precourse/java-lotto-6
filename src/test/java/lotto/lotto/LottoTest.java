package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("각 로또 번호가 1~45 범위에 들지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("lotto.lotto.LottoNumberArgumentProvider#provideExceptionInput")
    void createLottoByOverRangeNumber(List<Integer> input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 모든 조건을 만족할 때의 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("lotto.lotto.LottoNumberArgumentProvider#provideCorrectInput")
    void createLottoByCorrectNumber(List<Integer> input) {
        Lotto lotto = new Lotto(input);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 비교 테스트")
    @ParameterizedTest
    @MethodSource("lotto.lotto.LottoCompareArgumentProvider#provideInput")
    void compareTest(List<Integer> input1, List<Integer> input2, int result) {
        Lotto lotto1 = new Lotto(input1);
        Lotto lotto2 = new Lotto(input2);

        assertThat(lotto1.compare(lotto2)).isEqualTo(result);
    }
}