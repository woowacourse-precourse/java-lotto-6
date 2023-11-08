package lotto.domain;

import lotto.constants.message.ErrorMessage;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 번호 객체에 대해")
class LottoTest {

    private static final String error = ErrorMessage.ERROR_TAG.toString();

    static Stream<List<Integer>> winningNumbersErrorSource() {
        return Stream.of(List.of(0, 2, 3, 99, 5, 6), List.of(55, 56, 57, 58, 59, 60));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @DisplayName("로또 번호가 1 부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("winningNumbersErrorSource")
    void When_SaveWinningNumbers_Then_ThrowException(List<Integer> value) {
        assertThatThrownBy(() -> Lotto.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @DisplayName("리스트 타입의 숫자들 객체에 저장할 수 있다")
    @Test
    void When_CreateLotto_Then_NotEqual() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        //when
        List<Integer> lotto1Numbers = lotto.getNumbers();

        //then
        assertThat(lotto1Numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}