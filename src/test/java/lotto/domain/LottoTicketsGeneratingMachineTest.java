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
    @DisplayName("로또 티켓 생성 실패 테스트 - 생성할 수 없는 개수")
    @ValueSource(ints = {-1, 0})
    void createLottoTicketsImpossibleInitSizeFailTest(int initSize) {
        LottoTicketsGeneratingMachine lottoTicketsGeneratingMachine = new LottoTicketsGeneratingMachine();
        assertThrows(IllegalArgumentException.class,
                () -> lottoTicketsGeneratingMachine.generateRandomLottoTickets(initSize));
    }

    @ParameterizedTest
    @DisplayName("로또 티켓 생성 성공 테스트")
    @ValueSource(ints = {1, 10, 100})
    void createLottoTicketsSuccessTest(int initSize) {
        LottoTicketsGeneratingMachine lottoTicketsGeneratingMachine = new LottoTicketsGeneratingMachine();
        LottoTickets lottoTickets = assertDoesNotThrow(
                () -> lottoTicketsGeneratingMachine.generateRandomLottoTickets(initSize));
        int size = lottoTickets.getLottoTickets()
                .size();
        assertThat(size).isEqualTo(initSize);
    }
}
