package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,20,30,40,45"})
    void create_유효한_로또_번호(String input) {
        Lotto.create(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,test", "0,1,2,3,4,5", "1,2,3,4,5,46", "1,2,3,4,5,6,7"})
    void create_유효하지_않은_로또_번호(String input) {
        assertThatThrownBy(() -> Lotto.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}