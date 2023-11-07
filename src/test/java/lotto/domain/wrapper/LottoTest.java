package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.handler.ErrorHandler.INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개 보다 적거나 많다면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9", "1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3"})
    void createLottoByInvalidSize(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_SIZE.getException().getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}