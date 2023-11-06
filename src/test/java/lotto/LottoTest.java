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
    @DisplayName("로또 번호에 1~45 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,66)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정렬이 되었는지 확인한다.")
    @Test
    void sortedLottoNum() {
        List<Integer> num = List.of(6,2,4,5,1,10);
        List<Integer> ans = List.of(1,2,4,5,6,10);

        Lotto lotto = new Lotto(num);

        assertThat(lotto.toString()).isEqualTo(ans.toString());
    }
}