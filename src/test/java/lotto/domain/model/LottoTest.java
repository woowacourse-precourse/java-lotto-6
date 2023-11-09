package lotto.domain.model;

import static lotto.exception.lottonumbersexception.NumbersErrorMessage.INSUFFICIENT_NUMBERS_COUNT;
import static lotto.exception.lottonumbersexception.NumbersErrorMessage.OUT_OF_NUMBERS_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.lottonumbersexception.LottoNumbersInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfNumberRange() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(LottoNumbersInputException.class)
                .hasMessage(OUT_OF_NUMBERS_RANGE.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개 미만이라면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoNumbersInputException.class)
                .hasMessage(INSUFFICIENT_NUMBERS_COUNT.getMessage());
    }
}