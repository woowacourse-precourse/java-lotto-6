package lotto;

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
    @DisplayName("존재 유무 확인 매소드 테스트.")
    @Test
    void lottoContains_test(){
        Lotto L = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(L.lottoContains(2)).isEqualTo(true);
        assertThat(L.lottoContains(0)).isEqualTo(false);
    }

    @DisplayName("맞춘 숫자 세기 매소드 테스트.")
    @Test
    void countMatch_test(){
        Lotto L = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(L.countMatch(List.of(1,2,3,4,5,6))).isEqualTo(6);
        assertThat(L.countMatch(List.of(1,11,10,9,8,7))).isEqualTo(1);
    }
}