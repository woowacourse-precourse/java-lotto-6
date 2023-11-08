package lotto.v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.v3.util.LottoConstants.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoMachineTest {
    @DisplayName("LottoMachine은 중복되지 않는 번호로 로또를 생성해야 한다.")
    @Test
    void shouldGenerateLottoWithUniqueNumbers() {
        LottoMachine machine = new LottoMachine();
        Lotto lotto = machine.generateLottoNumbers();

        assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE.getValue())
                .doesNotHaveDuplicates();
    }

    @DisplayName("LottoMachine은 요청된 개수만큼 로또 티켓을 생성해야 한다.")
    @Test
    void shouldGenerateTheRequestedNumberOfLottoTickets() {
        LottoMachine machine = new LottoMachine();
        int requestedCount = 5; // 테스트용으로 요청할 로또 티켓의 수

        assertThatNoException().isThrownBy(() -> machine.generateTickets(requestedCount));

        List<Lotto> tickets = machine.generateTickets(requestedCount);

        assertThat(tickets).hasSize(requestedCount);
        for (Lotto ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE.getValue())
                    .doesNotHaveDuplicates();
        }
    }

}