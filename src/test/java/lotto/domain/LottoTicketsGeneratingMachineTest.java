package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoTicketsGeneratingMachine;
import dto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsGeneratingMachineTest {
    @ParameterizedTest
    @DisplayName("로또 티켓 개수가 양수가 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 0})
    void createLottoTicketsNotPositiveInitSize(int initSize) {
        LottoTicketsGeneratingMachine lottoTicketsGeneratingMachine = new LottoTicketsGeneratingMachine();
        assertThrows(IllegalArgumentException.class,
                () -> lottoTicketsGeneratingMachine.generateRandomLottoTickets(initSize));
    }

    @ParameterizedTest
    @DisplayName("로또 티켓 정상 생성")
    @ValueSource(ints = {1, 10, 100})
    void createLottoTickets(int initSize) {
        LottoTicketsGeneratingMachine lottoTicketsGeneratingMachine = new LottoTicketsGeneratingMachine();
        LottoTickets lottoTickets = assertDoesNotThrow(
                () -> lottoTicketsGeneratingMachine.generateRandomLottoTickets(initSize));
        int size = lottoTickets.getLottoTickets()
                .size();
        assertThat(size).isEqualTo(initSize);
    }
}
