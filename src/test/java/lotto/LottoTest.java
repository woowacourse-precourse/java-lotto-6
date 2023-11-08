package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 로또 생성 - 크기 검증")
    @Test
    void testGenerateRandomLotto() {
        int buyAmount = 5000;
        List<Lotto> lottos = Application.generateRandomLottoTickets(buyAmount);
        int expectedLottoCount = buyAmount / Application.LOTTO_PRICE;
        assertEquals(expectedLottoCount, lottos.size());
    }

    @DisplayName("랜덤 로또 생성 - 번호 범위 검증")
    @Test
    void testGenerateRandomLottoTicketNumberRange() {
        Lotto lotto = Application.generateRandomLottoTicket();
        for (int number : lotto.getNumbers()) {
            assertTrue(number >= Application.LOTTO_MIN_NUMBER && number <= Application.LOTTO_MAX_NUMBER);
        }
    }

    @DisplayName("랜덤 로또 생성 - 중복 검증")
    @Test
    void testGenerateRandomLottoTicketNoDuplicates() {
        Lotto lotto = Application.generateRandomLottoTicket();
        List<Integer> numbers = lotto.getNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                assertNotEquals(numbers.get(i), numbers.get(j));
            }
        }
    }

    @DisplayName("랜덤 로또 생성 - 정렬 검증")
    @Test
    void testGenerateRandomLottoTicketSorted() {
        Lotto lotto = Application.generateRandomLottoTicket();
        List<Integer> numbers = lotto.getNumbers();
        for (int i = 1; i < numbers.size(); i++) {
            assertTrue(numbers.get(i - 1) < numbers.get(i));
        }
    }
}