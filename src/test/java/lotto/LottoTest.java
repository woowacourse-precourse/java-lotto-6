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
    @DisplayName("로또 번호에 범위에 맞지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidInteger(){
        assertThatThrownBy(()-> new Lotto(List.of(0,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어 저장된다.")
    @Test
    void createLottoWithNaturalOrder(){
        Lotto lotto = new Lotto(List.of(6,5,4,3,2,1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("1등 당첨 확인")
    @Test
    void winFirstLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.Score(List.of(1, 2, 3, 4, 5, 6), 7)).isEqualTo(PRIZE.FIRST);
    }

    @DisplayName("2등 당첨 확인")
    @Test
    void winSecondLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.Score(List.of(1, 2, 3, 4, 5, 7), 6)).isEqualTo(PRIZE.SECOND);
    }

    @DisplayName("3등 당첨 확인")
    @Test
    void winThirdLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.Score(List.of(1, 2, 3, 4, 5, 7), 8)).isEqualTo(PRIZE.THIRD);
    }

    @DisplayName("4등 당첨 확인")
    @Test
    void winForthLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.Score(List.of(1, 2, 3, 4, 7, 8), 9)).isEqualTo(PRIZE.FORTH);
    }

    @DisplayName("5등 당첨 확인")
    @Test
    void winFifthLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.Score(List.of(1, 2, 3, 7, 8, 9), 10)).isEqualTo(PRIZE.FIFTH);
    }

    @DisplayName("실패 확인")
    @Test
    void loseLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.Score(List.of(1, 2, 30, 31, 32, 33), 10)).isEqualTo(PRIZE.FAIL);
    }
}