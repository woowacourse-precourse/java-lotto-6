package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("로또 번호가 1부터 45 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, -100, 89)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 문자열 알맞은 형태로 변환했는지 확인한다.")
    @Test
    void checkLottoByString() {
        assertThat(new Lotto(List.of(3, 43, 15, 9, 13, 6)).getNumbers())
                .isEqualTo(List.of(3, 43, 15, 9, 13, 6));
    }

//    @DisplayName("로또에서 1부터 45까지 숫자가 몇 개 있는지 확인한다.")
//    @Test
//    void checkLottoNumbersByCounters() {
//        assertThat(new Lotto(List.of(3, 43, 15, 9, 13, 6)).getNumbersCounters())
//                .isEqualTo(
//                        new int[]{
//                                0, 0, 0, 1, 0, // 4
//                                0, 1, 0, 0, 1, // 9
//                                0, 0, 0, 1, 0, // 14
//                                1, 0, 0, 0, 0, // 19
//                                0, 0, 0, 0, 0, // 24
//                                0, 0, 0, 0, 0, // 29
//                                0, 0, 0, 0, 0, // 34
//                                0, 0, 0, 0, 0, // 39
//                                0, 0, 0, 1, 0, // 44
//                                0,             // 45
//                        });
//    }
}