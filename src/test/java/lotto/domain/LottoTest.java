package lotto.domain;

import static lotto.common.ErrorMessages.DUPLICATE_NUMBERS_MESSAGE;
import static lotto.common.ErrorMessages.INVALID_NUMBERS_COUNT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.InputValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호를 생성한다.")
    @Test
    void createLottoNumbers() {
        Lotto lotto = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getNumbers()).extracting("number")
                .containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InputValidationException.class)
                .hasMessageContaining(INVALID_NUMBERS_COUNT_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(InputValidationException.class)
                .hasMessageContaining(DUPLICATE_NUMBERS_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호에 포함되어 있으면 true를 반환한다")
    @Test
    void containsNumber() {
        Lotto lotto = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.containsNumber(new LottoNumber(3))).isTrue();
    }

    @DisplayName("로또 번호가 주어지면 일치하는 숫자의 개수를 반환한다.")
    @Test
    void getCountingMatchingNumbers() {
        Lotto lotto = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));

        int matchingNumbers = lotto.getCountingMatchingNumbers(Lotto.createLotto(List.of(2, 3, 4, 5, 6, 7)));

        assertThat(matchingNumbers).isEqualTo(5);
    }
}