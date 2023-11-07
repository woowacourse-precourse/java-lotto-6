package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
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
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,6", "1,2,3,4,5,7,5", "1,2,3,11,12,13,3"})
    @DisplayName("일치하는 로또 번호 개수를 반환한다.")
    void calculateMatchNumber(int num1, int num2, int num3, int num4, int num5, int num6, int expected) {
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(num1, num2, num3, num4, num5, num6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int matchCount = lotto.calculateMatchNumber(winningNumber);
        Assertions.assertThat(matchCount).isEqualTo(expected);
    }
}