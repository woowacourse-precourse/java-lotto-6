package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("로또 번호가 범위를 넘어간다면 예외가 발생한다.(MAX 값을 넘은 경우)")
    @Test
    void createLottoByOverMaxRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 넘어간다면 예외가 발생한다.(MIN 값을 넘은 경우)")
    @Test
    void createLottoByOverMinRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void generateLottoTest() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 6, 6);
        for (int i = 1; i <= 6; i++) {
            assertTrue(numbers.contains(i));
        }
    }

    @DisplayName("로또 오름차순 정렬 테스트")
    @Test
    void sortLottoTest() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 6, 6);
        assertThat(numbers.stream().sorted().collect(Collectors.toList())).containsExactly(1, 2, 3, 4, 5, 6);
    }
}