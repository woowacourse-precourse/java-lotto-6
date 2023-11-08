package lotto;

import java.util.Arrays;
import lotto.model.Lotto;
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

    @DisplayName("로또 번호에 0~45 범위 밖의 숫자가 있으면 예외 발생한다.")
    @Test
    void createLottoByLargeOutRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 58)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 0~45 범위 밖의 숫자가 있으면 예외 발생한다.")
    @Test
    void createLottoBySmallOutRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정렬 되어야한다.")
    @Test
    void sortedTest(){
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        assertThat(lotto.sorted(lotto.getNumbers()))
                .isSorted();

    }
}