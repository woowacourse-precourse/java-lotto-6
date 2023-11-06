package lotto.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("문자열 반환 테스트")
    void toStringTest() {
        List<Integer> numbers = List.of(2, 3, 5, 7, 13, 31);
        Lotto lotto = new Lotto(numbers);
        String expectedResult = "[2, 3, 5, 7, 13, 31]";

        assertThat(lotto.toString()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("일치하는 번호 구하기 테스트")
    void countSameNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        int expectedSameNumbers = 5;

        assertThat(lotto.countSameNumbers(winningLotto)).isEqualTo(expectedSameNumbers);
    }

    @Test
    @DisplayName("보너스 번호 일치 기능 테스트")
    void countSameBonusNumberTest() {
        int bonusNumber = 30;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 30));

        assertTrue(lotto.countSameBonusNumber(bonusNumber));
    }
}