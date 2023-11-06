package lotto.domain.entity.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.config.ValidatorConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();
    private static final List<Integer> numbers = Arrays.asList(3, 42, 10, 34, 21, 25);

    @DisplayName("유효성 검사")
    @Nested
    class validate {
        @DisplayName("로또 번호의 개수가 6개 보다 적으면 예외가 발생한다.")
        @Test
        void createLottoByLackSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + "로또 번호는 6개 입니다.");

        }

        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + "로또 번호는 6개 입니다.");
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + "로또 번호에 중복된 번호가 있습니다.");
        }

        @DisplayName("로또 번호들은 1~45사이의 숫자들이 아니면 예외가 발상한다.")
        @ParameterizedTest
        @CsvSource({
                "0,1,2,3,4,5",
                "1,2,3,4,5,46",
        })
        void createLottoByNumberInRange(int number1, int number2, int number3, int number4, int number5, int number6) {
            List<Integer> lottoNumbers = Arrays.asList(number1, number2, number3, number4, number5, number6);
            assertThatThrownBy(() -> new Lotto(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @DisplayName("정렬된 로또 번호들을 반환합니다.")
    @Test
    void getSortedAscending() {
        List<Integer> answer = new ArrayList<>(numbers);
        Collections.sort(answer);
        Lotto lotto = new Lotto(numbers);

        List<Integer> result = lotto.getSortedAscending();

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("처음 입력했던 순서대로 로또 번호들을 반환합니다.")
    @Test
    void getNumbers() {
        Lotto lotto = new Lotto(numbers);

        List<Integer> result = lotto.getNumbers();

        assertThat(result).isEqualTo(numbers);
    }
}