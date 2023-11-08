package lotto;

import lotto.model.Lotto;
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

    @DisplayName("로또 번호는 생성 순서와 관계없이 오름차순으로 정렬된다.")
    @Test
    void checkListIsSorted() {
        assertThat(new Lotto(List.of(45,44,32,40,6,7)).printLotto())
                .isEqualTo("[6, 7, 32, 40, 44, 45]");
    }

    @DisplayName("로또번호를 당첨번호로 이분검색했을 때 존재하지 않으면 음수를 반환한다.")
    @Test
    void binarySearchLotto() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .match(10))
                .isLessThanOrEqualTo(-1);
    }

}