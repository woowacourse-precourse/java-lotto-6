package lotto;

import lotto.domain.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("로또 번호에 중복된 숫자가 있고 중복을 제거했을 때 길이가 6이어도 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedAndOverSizeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoByOverSize(int invalidRangeNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, invalidRangeNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 성공")
    @Test
    void createLottoSuccess() {
        assertThatNoException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("당첨 번호에 대한 당첨 숫자 개수 계산하기 성공")
    @Test
    public void calculateCountOfNumberEqualToWinningNumber() throws  Exception {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto target = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        int expected = 3;
        //when
        int result = lotto.calculateCountOfNumberEqualToWinningNumber(target);
        //then
        assertThat(result).isEqualTo(expected);
    }
}