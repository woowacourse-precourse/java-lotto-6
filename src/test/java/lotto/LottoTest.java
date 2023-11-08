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
    // TODO: 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 45가 넘으면 예외가 발생한다.")
    @Test
    void createLottoByOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnder1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 출력")
    @Test
    void printLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.printNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
    // 로또 번호 입력받은 후 integer로 변환하기 전 변수를 넣어야 할 듯
//    @DisplayName("로또 번호에 숫자가 아닌 경우")
//    @Test
//    void createLottoByInteger() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, "a")))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
    
}