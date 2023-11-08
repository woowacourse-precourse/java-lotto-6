package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("사용자 입력 숫자와 생성된 로또 숫자가 5개 일치하고 보너스도 일치할 때를 테스트한다.")
    @Test
    void compareWithUserNumbersWithBonus() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,10));
        List<Integer> userNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 10;

        int matchCount = lotto.compareWithUserNumbers(userNumbers, bonusNumber);

        assertThat(matchCount).isEqualTo(15);
    }

    @DisplayName("사용자 입력 숫자와 생성된 로또 숫자가 5개 일치하고 보너스는 일치하지 않을 때를 테스트한다.")
    @Test
    void compareWithUserNumbersWithoutBonus() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,10));
        List<Integer> userNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 15;

        int matchCount = lotto.compareWithUserNumbers(userNumbers, bonusNumber);

        assertThat(matchCount).isEqualTo(5);
    }
}