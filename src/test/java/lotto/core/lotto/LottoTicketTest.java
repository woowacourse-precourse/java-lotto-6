package lotto.core.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketTest {
    static Stream<List<Integer>> lottoTicketProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1),
                Arrays.asList(1, 2, 3, 4, 5, 5),
                Arrays.asList(1, 2, 3, 4, 5, 55)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoTicketProvider")
    void testInvalidLottoTickets(List<Integer> numbers) {
        assertThatThrownBy(() -> new LottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이라면 예외가 발생한다.")
    @Test
    void createLottoByLowerSize() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverNumberRange() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}