package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.errors.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoManager lm = LottoManager.getInstance();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2, 3, 4, 5",  "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("번호의 개수가 6이 아닐 때 예외처리")
    void test_newLotto_1(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lm.setLuckyNumbers(numbers)))
                .withMessage(ErrorMessage.WRONG_LUCKY_NUMBER_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 2, 3, 4, 5"})
    @DisplayName("중복된 숫자가 있을 때 예외처리")
    void test_newLotto_2(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lm.setLuckyNumbers(numbers)))
                .withMessage(ErrorMessage.NO_DUPLICATED_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46", "-1, 2, 3, 4, 5, 6"})
    @DisplayName("1~45 범위를 벗어나는 숫자가 있을 때 예외처리")
    void test_newLotto_3(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lm.setLuckyNumbers(numbers)))
                .withMessage(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
    }

    // TODO , 로 끝날 때 별도 예외처리 필요
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6, "})
    @DisplayName("적절한 값이 들어올 때 테스트 통과")
    void test_newLotto_4(String numbers) {
        assertThatCode(() -> new Lotto(lm.setLuckyNumbers(numbers)))
                .doesNotThrowAnyException();
    }
}