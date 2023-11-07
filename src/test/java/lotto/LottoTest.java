package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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
    @DisplayName("로또 번호에 1에서 45까지의 숫자를 제외한 숫자가 나오면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    @Test
    void createLottoInAsd() {
    	assertSimpleTest(() -> {
    		Lotto lotto = new Lotto(List.of(45, 30, 21, 1, 7, 9));
    		List<Integer> expectedNumbers = List.of(1, 7, 9, 21, 30, 45);
    		assertThat(expectedNumbers)
    			.isEqualTo(lotto.sortInAsd());
        });
    }
    
}