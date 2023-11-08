package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTicketsTest {
    @ParameterizedTest
    @ValueSource(ints = {4,8,16})
    @DisplayName("LottoTickets_생성시_Lotto_객체_개수_확인")
    void compareLottoTicketsSizeByCount(int inputCount) {
        List<Lotto> randomNumbers = new LottoTickets(inputCount).getTickets();

        assertThat(randomNumbers.size())
                .isEqualTo(inputCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20})
    @DisplayName("LottoTickets_생성시_Lotto_객체_범위_확인")
    void generateRandomLottoNumbersReturnValidNumbers(int inputCount) {
        List<Lotto> randomNumbers = new LottoTickets(inputCount).getTickets();

        for (Lotto randomNumber : randomNumbers) {
            for (int number : randomNumber.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20})
    @DisplayName("LottoTickets_생성시_Lotto_객체_중복_확인")
    void generateRandomLottoNumbersReturnNotDuplicatedNumbers(int inputCount) {
        List<Lotto> randomNumbers = new LottoTickets(inputCount).getTickets();

        for (Lotto randomNumber : randomNumbers) {
            HashSet<Integer> testSet = new HashSet<>(randomNumber.getNumbers());
            assertTrue(testSet.size() == 6);
        }
    }
}
